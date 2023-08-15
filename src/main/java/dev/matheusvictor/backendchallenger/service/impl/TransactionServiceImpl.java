package dev.matheusvictor.backendchallenger.service.impl;

import dev.matheusvictor.backendchallenger.domain.transaction.Transaction;
import dev.matheusvictor.backendchallenger.domain.user.User;
import dev.matheusvictor.backendchallenger.dtos.TransactionDTO;
import dev.matheusvictor.backendchallenger.repositories.TransactionRepository;
import dev.matheusvictor.backendchallenger.service.TransactionService;
import dev.matheusvictor.backendchallenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final UserService userService;

  private final TransactionRepository transactionRepository;

  private final RestTemplate restTemplate;

  @Override
  public void createTransaction(TransactionDTO transactionDTO) throws Exception {
    User sender = this.userService.findUserById(transactionDTO.senderId());
    User receiver = this.userService.findUserById(transactionDTO.receiverId());

    userService.validateTransaction(sender, transactionDTO.value());

    boolean isAuthorized = this.authorizeTransaction(sender, transactionDTO.value());

    if (!isAuthorized) throw new Exception("Transaction not authorized");

    Transaction newTransaction = createNewTransaction(sender, receiver, transactionDTO.value());

    sender.setBalance(sender.getBalance().subtract(transactionDTO.value()));
    receiver.setBalance(receiver.getBalance().add(transactionDTO.value()));

    this.transactionRepository.save(newTransaction);
    this.userService.saveUser(sender);
    this.userService.saveUser(receiver);
  }

  @Override
  public boolean authorizeTransaction(User sender, BigDecimal value) {
    ResponseEntity<Map> authorizationResponse = restTemplate
            .getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

    if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
      String message = (String) authorizationResponse.getBody().get("message");

      return "Autorizado".equalsIgnoreCase(message);
    } else return false;
  }

  private Transaction createNewTransaction(User sender, User receiver, BigDecimal value) {
    Transaction transaction = new Transaction();
    transaction.setAmount(value);
    transaction.setSender(sender);
    transaction.setReceiver(receiver);
    transaction.setTimestap(LocalDateTime.now());

    return transaction;
  }
}
