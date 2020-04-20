package com.example.demo.controller;

import com.example.demo.model.Equipment;
import com.example.demo.exception.EquipmentNotFoundException;
import com.example.demo.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/outdoor-equipments")
public class OutdoorStoreController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping
    public List findAll() {
        Optional<List> equipments = equipmentRepository.findAll();
        return equipments.orElse(Collections.emptyList());
    }

    @GetMapping("/category/{equipmentCategory}")
    public List findByTitle(@PathVariable String equipmentCategory) {
        return equipmentRepository.findByCategory(equipmentCategory);
    }

    @GetMapping("/{id}")
    public Equipment findOne(@PathVariable Integer id) {
        Optional<Equipment> eq = equipmentRepository.findAllById(id);
        if(!eq.isEmpty()){
            throw new EquipmentNotFoundException("Equipment not found");
        }
        return eq.orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment create(@RequestBody Equipment equipment) throws Exception {
        return equipmentRepository.save(equipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!equipmentRepository.findAllById(id).isPresent()){
            throw new EquipmentNotFoundException("Equipment not found");
        }
        equipmentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Equipment updateBook(@RequestBody Equipment equipment, @PathVariable int id) throws EquipmentNotFoundException {
        if(!equipmentRepository.findAllById(id).isPresent()){
            throw new EquipmentNotFoundException("Equipment not found");
        }
        equipment.setId(id);

        return equipmentRepository.update(equipment);
    }
}
