package fii.practic.yonder.demo.service;

import fii.practic.yonder.demo.entity.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAll();
    Doctor getById(Long id);
    Doctor save(Doctor doctor);
}
