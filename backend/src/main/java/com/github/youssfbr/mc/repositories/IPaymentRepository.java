package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
