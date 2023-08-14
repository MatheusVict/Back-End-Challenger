package dev.matheusvictor.backendchallenger.repositories;

import dev.matheusvictor.backendchallenger.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRepository, Long> {
  Optional<User> findUserByDocument(String document);
}
