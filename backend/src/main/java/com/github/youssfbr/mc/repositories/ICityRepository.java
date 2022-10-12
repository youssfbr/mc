package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {
}
