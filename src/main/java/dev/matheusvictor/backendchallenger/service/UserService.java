package dev.matheusvictor.backendchallenger.service;

import dev.matheusvictor.backendchallenger.domain.user.User;
import dev.matheusvictor.backendchallenger.dtos.UserDTO;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

  void validateTransaction(User sender, BigDecimal amount);

  User findUserById(Long id);

  void saveUser(User user);

  User createUser(UserDTO userDTO);

  List<User> getALlUsers();
}
