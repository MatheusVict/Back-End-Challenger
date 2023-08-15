package dev.matheusvictor.backendchallenger.controllers;

import dev.matheusvictor.backendchallenger.domain.transaction.Transaction;
import dev.matheusvictor.backendchallenger.dtos.TransactionDTO;
import dev.matheusvictor.backendchallenger.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping
  public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception{
    return ResponseEntity.ok(transactionService.createTransaction(transactionDTO));
  }
}
