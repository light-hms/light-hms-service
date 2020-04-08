package com.lighthms.lighthmsservice;

import com.lighthms.lighthmsservice.organization.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final HealthInstitutionRepository healthInstitutionRepository;

    @Override
    public void run(String... args) throws Exception {

        Hospital victoria = new Hospital("Victoria")
                .addCareUnit(new CareUnit("ICU-1", Department.GENERAL).addBeds(30))
                .addCareUnit(new CareUnit("ICU-2", Department.GENERAL).addBeds(20))
                .addCareUnit(new CareUnit("ICU-3", Department.GENERAL).addBeds(10));
        Hospital minto = new Hospital("Minto")
                .addCareUnit(new CareUnit("ICU-1", Department.GENERAL).addBeds(30))
                .addCareUnit(new CareUnit("ICU-2", Department.GENERAL).addBeds(20))
                .addCareUnit(new CareUnit("ICU-3", Department.GENERAL).addBeds(10));
        Hospital vaniVilas = new Hospital("Vani Vilas")
                .addCareUnit(new CareUnit("ICU-1", Department.GENERAL).addBeds(30))
                .addCareUnit(new CareUnit("ICU-2", Department.GENERAL).addBeds(20))
                .addCareUnit(new CareUnit("ICU-3", Department.GENERAL).addBeds(10));
        Hospital mantri = new Hospital("Pradhan Mantri")
                .addCareUnit(new CareUnit("ICU-1", Department.GENERAL).addBeds(30))
                .addCareUnit(new CareUnit("ICU-2", Department.GENERAL).addBeds(20))
                .addCareUnit(new CareUnit("ICU-3", Department.GENERAL).addBeds(10));

        HealthInstitution healthInstitution = new HealthInstitution("BMC", "Bangalore", Institution.HOSPITAL)
                .addHospital(victoria).addHospital(minto).addHospital(vaniVilas).addHospital(mantri);
        healthInstitution = healthInstitutionRepository.save(healthInstitution);
        log.info("Loaded data: {}", healthInstitution);
    }
}
