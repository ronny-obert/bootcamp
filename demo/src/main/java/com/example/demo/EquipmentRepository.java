package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {
    Optional<Equipment> getById(int id);

    Optional<List> findAll();

    List findByCategory(String equipmentCategory);

    Equipment save(Equipment equipment) throws Exception;

    int deleteById(Long id);

    Equipment update(Equipment equipment) throws EquipmentNotFoundException;
}
