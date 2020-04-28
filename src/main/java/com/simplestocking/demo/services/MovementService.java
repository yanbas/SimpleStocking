package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Material;
import com.simplestocking.demo.model.Movement;

import java.util.List;
import java.util.Optional;

public interface MovementService {

    List<Movement> findAll();
    Optional<Movement> findById(String id);
    Movement create(Movement movement);

}
