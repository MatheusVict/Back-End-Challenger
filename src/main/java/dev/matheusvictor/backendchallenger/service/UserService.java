package dev.matheusvictor.backendchallenger.service;

import dev.matheusvictor.backendchallenger.domain.user.User;

import java.math.BigDecimal;

public interface UserService {

  void validateTransaction(User sender, BigDecimal amount);

  User findUserById(Long id);

  void saveUser(User user);
}
