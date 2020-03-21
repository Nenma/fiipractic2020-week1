package fii.practic.yonder.demo;

import fii.practic.yonder.demo.entity.Doctor;
import fii.practic.yonder.demo.repository.DoctorJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DoctorJdbcRepository repository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setFirstName("Cristi");
        doctor.setLastName("Rosu");
        doctor.setSpeciality("Medic");

        repository.insert(doctor);

        logger.info("All doctors -> {}", repository.findAll());*/
    }
}
