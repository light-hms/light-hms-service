package com.lighthms.lighthmsservice.people;

import com.lighthms.lighthmsservice.BaseEntity;
import com.lighthms.lighthmsservice.organization.Bed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor
@ToString(of = {"person"})
public class Patient extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    private String code;

    private String externalPatientId;

    @OneToOne
    private Bed bed;

    public Patient(Person person, String code, String externalPatientId) {
        this.person = person;
        this.code = code;
        this.externalPatientId = externalPatientId;
    }

    public Patient(Person person, String code) {
        this(person, code, null);
    }

    public Patient(Person person) {
        this(person, null);
    }


}

