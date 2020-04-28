package com.simplestocking.demo.repository;

import com.simplestocking.demo.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, String> {
}
