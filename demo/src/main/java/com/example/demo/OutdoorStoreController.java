package com.example.demo;

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
    private EquipmentRepostoryJPA equipmentRepositoryJpa;

    @GetMapping
    public List findAll() {
        List<Equipment> all = equipmentRepositoryJpa.findAll();
        return all;
    }

    @GetMapping("/category/{equipmentCategory}")
    public List findByTitle(@PathVariable String equipmentCategory) {
        return equipmentRepositoryJpa.findByCategory(equipmentCategory);
    }

    @GetMapping("/items")
    public List findItems(@RequestParam String category, @RequestParam String model) {
        return equipmentRepositoryJpa.findByCategoryAndModel(category, model);
    }

    @GetMapping("/{id}")
    public Equipment findOne(@PathVariable Integer id) {
        return equipmentRepositoryJpa.findAllById(id)
                .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment create(@RequestBody Equipment equipment) throws Exception {
        return equipmentRepositoryJpa.save(equipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!equipmentRepositoryJpa.findById(id).isPresent()){
            throw new EquipmentNotFoundException("Equipment not found");
        }
        equipmentRepositoryJpa.deleteById(id);
    }

    @PutMapping("/{id}")
    public Equipment updateBook(@RequestBody Equipment equipment, @PathVariable int id) throws EquipmentNotFoundException {
        if(!equipmentRepositoryJpa.findById(id).isPresent()){
            throw new EquipmentNotFoundException("Equipment not found");
        }
        equipment.setId(id);

        return equipmentRepositoryJpa.save(equipment);
    }
}
