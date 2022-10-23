package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {

    @Transactional(readOnly = true)
    Optional<Client> findByEmail(final String cpf);
}
