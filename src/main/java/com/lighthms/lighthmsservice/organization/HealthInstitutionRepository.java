package com.lighthms.lighthmsservice.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface HealthInstitutionRepository extends JpaRepository<HealthInstitution, BigInteger> {
}
