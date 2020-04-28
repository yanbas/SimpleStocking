package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Adjustment;

import java.util.List;
import java.util.Map;

public interface AdjustmentService {

    List<Map<Object, Object>> findAll();
    List<Map<Object, Object>> findById(String id);
    Adjustment create(Adjustment adjustment);

}
