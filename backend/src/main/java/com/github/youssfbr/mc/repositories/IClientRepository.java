package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
