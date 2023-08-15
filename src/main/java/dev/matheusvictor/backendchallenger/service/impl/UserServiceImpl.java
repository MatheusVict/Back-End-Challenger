package dev.matheusvictor.backendchallenger.service.impl;

import dev.matheusvictor.backendchallenger.domain.user.User;
import dev.matheusvictor.backendchallenger.domain.user.UserType;
import dev.matheusvictor.backendchallenger.dtos.UserDTO;
import dev.matheusvictor.backendchallenger.repositories.UserRepository;
import dev.matheusvictor.backendchallenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public void validateTransaction(User sender, BigDecimal amount) {
    if (sender.getUserType() == UserType.SHOPKEEPER)
      throw new IllegalArgumentException("Shopkeepers cannot make transactions");

    if (sender.getBalance().compareTo(amount) < 0)
      throw new IllegalArgumentException(String
              .format("Insufficient funds. Your balance is %s", sender.getBalance()));
  }

  @Override
  public User findUserById(Long id) {
    return this.userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User Not found"));

  }

  @Override
  public void saveUser(User user) {
    this.userRepository.save(user);
  }

  @Override
  public User createUser(UserDTO userDTO) {
    User newUser = new User(userDTO);
     this.saveUser(newUser);
     return newUser;
  }

  @Override
  public List<User> getALlUsers() {
    return this.userRepository.findAll();
  }
}
