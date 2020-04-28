package com.simplestocking.demo.repository;

import com.simplestocking.demo.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface MovementRepository extends JpaRepository<Movement, String> {

    @Transactional
    @Query(value = "select a.id, a.material_id, a.qty, a.status, a.transaction_date, a.pic, b.material_name from movement a inner join materials b on a.material_id = b.id where a.id = ?;",nativeQuery = true)
    List<Map<Object,Object>> getMovement(String id);

    @Transactional
    @Query(value = "select a.id, a.material_id, a.qty, a.status, a.transaction_date, a.pic, b.material_name from movement a inner join materials b on a.material_id = b.id;",nativeQuery = true)
    List<Map<Object,Object>> getMovements();

}
