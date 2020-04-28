package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Adjustment;
import com.simplestocking.demo.repository.AdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdjustmentServiceImpl implements AdjustmentService {

    @Autowired
    AdjustmentRepository adjustmentRepository;

    @Override
    public List<Map<Object, Object>> findAll() {
        return adjustmentRepository.getAdjustments();
//        return adjustmentRepository.findAll();
    }

    @Override
    public List<Map<Object, Object>> findById(String id) {
        return adjustmentRepository.getAdjustment(id);
//        return adjustmentRepository.findById(id);
    }

    @Override
    public Adjustment create(Adjustment adjustment) {
        adjustment.setCreatedDate(new Date());

        // Update Table Material
        adjustmentRepository.updateMaterial(adjustment.getQty(),adjustment.getMaterialId());

        //Update Table Movement
        adjustmentRepository.updateMovement(adjustment.getQty(), adjustment.getMovementId(), adjustment.getMaterialId());

        return adjustmentRepository.save(adjustment);
    }
}
