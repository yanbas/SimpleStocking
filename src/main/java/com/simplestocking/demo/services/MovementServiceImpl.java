package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Movement;
import com.simplestocking.demo.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovementServiceImpl implements MovementService {

    @Autowired
    MovementRepository movementRepository;

    @Override
    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    @Override
    public Optional<Movement> findById(String id) {
        return movementRepository.findById(id);
    }

    @Override
    public Movement create(Movement movement) {
        return movementRepository.save(movement);
    }
}
