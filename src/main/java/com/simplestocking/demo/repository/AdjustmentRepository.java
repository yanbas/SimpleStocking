package com.simplestocking.demo.repository;

import com.simplestocking.demo.model.Adjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AdjustmentRepository extends JpaRepository<Adjustment, String> {

    @Transactional
    @Modifying()
    @Query(value = "UPDATE materials SET qty = qty + ? WHERE id = ?;",nativeQuery = true)
    void updateMaterial(Integer qty, String id);

    @Transactional
    @Modifying()
    @Query(value = "UPDATE movement SET qty = qty + ? WHERE id = ? AND material_id = ?;",nativeQuery = true)
    void updateMovement(Integer qty, String id, String material_id);

}
