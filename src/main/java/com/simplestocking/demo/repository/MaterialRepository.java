package com.simplestocking.demo.repository;

import com.simplestocking.demo.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, String> {

}
