package dev.matheusvictor.backendchallenger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<TransactionRepository, Long> {
}
