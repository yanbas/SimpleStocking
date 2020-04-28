package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {

    List<Material> findAll();
    Optional<Material> findById(String id);
    Material create(Material material);

}
