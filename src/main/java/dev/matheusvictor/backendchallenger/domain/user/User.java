package dev.matheusvictor.backendchallenger.domain.user;

import dev.matheusvictor.backendchallenger.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false, unique = true)
  private String document;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column
  private BigDecimal balance;

  @Enumerated(EnumType.STRING)
  private UserType userType;

  public User(UserDTO userData) {
    this.firstName = userData.firstName();
    this.document = userData.document();
    this.lastName = userData.lastName();
    this.balance = userData.balance();
    this.userType = userData.userType();
    this.password = userData.password();
    this.email = userData.email();
  }
}
