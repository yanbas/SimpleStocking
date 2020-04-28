package com.simplestocking.demo.repository;

import com.simplestocking.demo.model.Adjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface AdjustmentRepository extends JpaRepository<Adjustment, String> {

    @Transactional
    @Modifying()
    @Query(value = "UPDATE materials SET qty = qty + ? WHERE id = ?;",nativeQuery = true)
    void updateMaterial(Integer qty, String id);

    @Transactional
    @Modifying()
    @Query(value = "UPDATE movement SET qty = qty + ? WHERE id = ? AND material_id = ?;",nativeQuery = true)
    void updateMovement(Integer qty, String id, String material_id);

    @Transactional
    @Query(value = "select a.id, a.adjustment_date, b.material_name, b.id as material_id, b.material_aliase, c.id as movement_id, a.qty, a.reason, a.pic from adjustment a \n" +
            "inner join materials b on a.material_id = b.id \n" +
            "inner join movement c on c.material_id = b.id and a.movement_id = c.id \n;",nativeQuery = true)
    List<Map<Object,Object>> getAdjustments();

    @Transactional
    @Query(value = "select a.id, a.adjustment_date, b.material_name, b.id as material_id, b.material_aliase, c.id as movement_id, a.qty, a.reason, a.pic from adjustment a \n" +
            "inner join materials b on a.material_id = b.id \n" +
            "inner join movement c on c.material_id = b.id and a.movement_id = c.id where a.id = ? \n;",nativeQuery = true)
    List<Map<Object,Object>> getAdjustment(String id);
}
