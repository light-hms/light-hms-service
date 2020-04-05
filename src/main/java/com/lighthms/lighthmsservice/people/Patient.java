package com.lighthms.lighthmsservice.people;

import com.lighthms.lighthmsservice.BaseEntity;
import com.lighthms.lighthmsservice.organization.Bed;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class Patient extends BaseEntity {

    private String code;
    private String externalPatientId;

    @OneToOne
    private Person person;

    @OneToOne
     private Bed bed;
}

