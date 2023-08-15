package dev.matheusvictor.backendchallenger.controllers;

import dev.matheusvictor.backendchallenger.domain.user.User;
import dev.matheusvictor.backendchallenger.dtos.UserDTO;
import dev.matheusvictor.backendchallenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(this.userService.getALlUsers());
  }
}
