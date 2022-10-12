package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateRepository extends JpaRepository<State, Long> {
}
