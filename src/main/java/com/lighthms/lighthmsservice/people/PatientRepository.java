package com.lighthms.lighthmsservice.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PatientRepository extends JpaRepository<Patient, BigInteger> {
}
