package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class EquipmentRepositoryDB implements EquipmentRepository {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public Optional<Equipment> findAllById(int id) {
        Equipment equipment = new Equipment();
        try {

            String sql = "SELECT * FROM tbl_equipment WHERE id = ?";

            equipment = jtm.queryForObject(sql, new Object[]{id},
                    new BeanPropertyRowMapper<>(Equipment.class));
            return Optional.of(equipment);
        }
        catch (Exception e) {
            return Optional.of(equipment);
        }
    }

    @Override
    public Optional<List> findAll() {

        String sql = "SELECT id, category, brand, name, stock, model, price FROM tbl_equipment";

        List<Equipment> equipments = jtm.query(sql, new Object[]{},
                new BeanPropertyRowMapper<>(Equipment.class));
        return Optional.of(equipments);
    }

    @Override
    public List findByCategory(String equipmentCategory) {
        return null;
    }

    @Override
    public Equipment save(Equipment equipment) throws Exception {
        String sql = "INSERT INTO tbl_equipment (category, brand, name, stock, model, price) VALUES\n" +
                "  (?, ?, ?, ?, ?, ? )";

        int a= jtm.update(sql, equipment.getCategory(), equipment.getBrand(), equipment.getName(), equipment.getStock(), equipment.getModel(), equipment.getPrice());

        if (a > 0) {
            return equipment;
        } else {
            throw new Exception();
        }

    }

    @Override
    public int deleteById(int id) {
        Equipment equipment = new Equipment();
        try {
            String sql = "DELETE FROM tbl_equipment WHERE id = ?";
            return jtm.update(sql, id);
        }
        catch (Exception e) {
            return 0;
        }

    }

    @Override
    public Equipment update(Equipment equipment) throws EquipmentNotFoundException {
        String sql = "UPDATE tbl_equipment set category = ?, brand = ?, name = ?, stock = ?, model = ?, price = ? WHERE id = ?";
        int result = jtm.update(sql, equipment.getCategory(), equipment.getBrand(), equipment.getName(), equipment.getStock(), equipment.getModel(), equipment.getPrice(), equipment.getId());

        if (result > 0) {
            return equipment;
        } else {
            throw new EquipmentNotFoundException("Equipment not found!");
        }
    }
}
