package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
