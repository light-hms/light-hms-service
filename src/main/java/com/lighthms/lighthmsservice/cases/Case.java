package com.lighthms.lighthmsservice.cases;

import com.lighthms.lighthmsservice.BaseEntity;
import com.lighthms.lighthmsservice.organization.Bed;
import com.lighthms.lighthmsservice.people.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
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
}
