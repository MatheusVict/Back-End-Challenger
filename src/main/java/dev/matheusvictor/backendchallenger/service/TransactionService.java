package dev.matheusvictor.backendchallenger.service;

import dev.matheusvictor.backendchallenger.domain.transaction.Transaction;
import dev.matheusvictor.backendchallenger.domain.user.User;
import dev.matheusvictor.backendchallenger.dtos.TransactionDTO;

import java.math.BigDecimal;

public interface TransactionService {
  Transaction createTransaction(TransactionDTO transactionDTO) throws Exception;

  boolean authorizeTransaction(User sender, BigDecimal value) throws Exception;
}
