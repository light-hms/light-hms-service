package com.lighthms.lighthmsservice.cases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;

@RepositoryRestResource
public interface CaseRepository extends JpaRepository<Case, BigInteger> {
}
