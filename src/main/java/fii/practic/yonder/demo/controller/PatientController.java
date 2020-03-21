package fii.practic.yonder.demo.controller;

import fii.practic.yonder.demo.dto.PatientDTO;
import fii.practic.yonder.demo.entity.Doctor;
import fii.practic.yonder.demo.entity.Email;
import fii.practic.yonder.demo.entity.Patient;
import fii.practic.yonder.demo.service.DoctorService;
import fii.practic.yonder.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PatientController {

    private PatientService patientService;
    private DoctorService doctorService;

    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientService.getById(id);
    }

    @PostMapping
    public Patient save(@RequestBody PatientDTO patientDTO) {
        Doctor doctorDb = doctorService.getById(patientDTO.getDoctorId());

        Email newEmail = new Email();
        newEmail.setEmailAddress(patientDTO.getEmailAddress());

        Patient newPatient = new Patient();
        newPatient.setDoctor(doctorDb);
        newPatient.setEmail(newEmail);
        newPatient.setAge(patientDTO.getAge());
        newPatient.setFirstName(patientDTO.getFirstName());
        newPatient.setLastName(patientDTO.getLastName());

        return patientService.save(newPatient);
    }

}
