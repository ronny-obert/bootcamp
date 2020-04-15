package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepostoryJPA extends CrudRepository<Equipment, Integer> {
    List<Equipment> findAll();
    Optional<Equipment>  findAllById(Integer id);
    List<Equipment> findByCategory(String equipmentCategory);
    List<Equipment> findByCategoryAndModel(String category, String model);
    void deleteById(Integer id);
}
