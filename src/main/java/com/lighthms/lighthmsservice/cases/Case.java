package com.lighthms.lighthmsservice.cases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lighthms.lighthmsservice.BaseEntity;
import com.lighthms.lighthmsservice.people.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"name", "patient"})
@NoArgsConstructor
@Table(name = "cases")
public class Case extends BaseEntity {

    private String name;

    @OneToOne
    private Patient patient;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaseEvent> events = new ArrayList<>(0);

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Investigation> investigations = new ArrayList<>(0);

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examination> examinations = new ArrayList<>(0);


    @JsonCreator
    public Case(String name, Patient patient) {
        this.name = name;
        this.patient = patient;
    }

    public Case addEvent(CaseEvent event) {
        this.events.add(event);
        return this;
    }
}
