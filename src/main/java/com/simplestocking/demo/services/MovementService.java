package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Movement;

import java.util.List;
import java.util.Map;

public interface MovementService {

    List<Map<Object, Object>> findAll();
    List<Map<Object, Object>> findById(String id);
    Movement create(Movement movement);

}
