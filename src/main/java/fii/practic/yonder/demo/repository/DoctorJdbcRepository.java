package fii.practic.yonder.demo.repository;

import fii.practic.yonder.demo.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Doctor> findAll() {
        return jdbcTemplate.query("select * from doctor", new BeanPropertyRowMapper<>(Doctor.class));
    }

    public void insert(Doctor doctor) {
        jdbcTemplate.update("insert into doctor(id, first_name, last_name, speciality) values(?, ?, ?, ?)",
                doctor.getId(), doctor.getFirstName(), doctor.getLastName(), doctor.getSpeciality());
    }
}
