package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Adjustment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdjustmentService {

    List<Adjustment> findAll();
    Optional<Adjustment> findById(String id);
    Adjustment create(Adjustment adjustment);

}
