package com.lighthms.lighthmsservice.cases;

import com.lighthms.lighthmsservice.AbstractIntegrationTest;
import com.lighthms.lighthmsservice.people.Patient;
import com.lighthms.lighthmsservice.people.PatientRepository;
import com.lighthms.lighthmsservice.people.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;

/**
 * Repository tests for {@link CaseRepository} .
 */

@Slf4j
public class CaseRepositoryIntegrationTests extends AbstractIntegrationTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CaseRepository caseRepository;


    @Test
    public void contextLoads() {
        log.info("test");
    }

    @Test
    public void addsNewCase() {

        Person person = new Person("Algernon", "Moncheff", LocalDate.of(1980, Month.JANUARY, 20), "+918877644553");
        Patient patient = new Patient(person, "P0000001");
        patient = patientRepository.save(patient);
        log.info("Added patient: {}", patient);

        Case travelHistory = new Case("Travel history :: Algernon", patient);
        travelHistory = caseRepository.save(travelHistory);

        Vital vital = new Vital(new Vital.HeartRate("72"), new Vital.BloodPressure("80/100"), new Vital.OxygenSaturation("98"), new Vital.Temperature("98.6"));
        CaseEvent initialEvent = new CaseEvent(vital);
        travelHistory = travelHistory.addEvent(initialEvent);

        travelHistory = caseRepository.save(travelHistory);
        log.info("Added case: {}", travelHistory);

    }
}
