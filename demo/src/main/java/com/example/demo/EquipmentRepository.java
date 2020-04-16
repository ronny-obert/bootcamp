package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {
    Optional<Equipment> findAllById(int id);

    Optional<List> findAll();

    List findByCategory(String equipmentCategory);

    Equipment save(Equipment equipment) throws Exception;

    int deleteById(int id);

    Equipment update(Equipment equipment) throws EquipmentNotFoundException;
}
