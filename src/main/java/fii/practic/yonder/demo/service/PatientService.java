package fii.practic.yonder.demo.service;

import fii.practic.yonder.demo.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAll();
    Patient getById(Long id);
    Patient save(Patient patient);
}
