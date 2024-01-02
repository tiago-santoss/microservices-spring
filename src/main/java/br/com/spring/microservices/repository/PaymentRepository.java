package br.com.spring.microservices.repository;

import br.com.spring.microservices.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
