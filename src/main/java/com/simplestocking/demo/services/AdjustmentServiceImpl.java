package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Adjustment;
import com.simplestocking.demo.repository.AdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdjustmentServiceImpl implements AdjustmentService {

    @Autowired
    AdjustmentRepository adjustmentRepository;

    @Override
    public List<Adjustment> findAll() {
        return adjustmentRepository.findAll();
    }

    @Override
    public Optional<Adjustment> findById(String id) {
        return adjustmentRepository.findById(id);
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
