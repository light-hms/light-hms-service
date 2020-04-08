package com.lighthms.lighthmsservice.organization;

import com.lighthms.lighthmsservice.BaseEntity;
import com.lighthms.lighthmsservice.people.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class Bed extends BaseEntity {
    private String name;

    @OneToOne
    private Patient patient;

    public Bed(String name) {
        this.name = name;
    }
}
