package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Material;
import com.simplestocking.demo.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> findById(String id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material create(Material material) {
        return materialRepository.save(material);
    }
}
