package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Movement;
import com.simplestocking.demo.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MovementServiceImpl implements MovementService {

    @Autowired
    MovementRepository movementRepository;

    @Override
    public List<Map<Object, Object>> findAll() {
        return movementRepository.getMovements();
//        return movementRepository.findAll();
    }

    public List<Map<Object, Object>> findById(String id) {
//        return movementRepository.findById(id);
        return movementRepository.getMovement(id);
    }

    @Override
    public Movement create(Movement movement) {
        return movementRepository.save(movement);
    }
}
