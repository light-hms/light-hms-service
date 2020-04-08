package com.lighthms.lighthmsservice.organization;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class HealthInstitution extends BaseEntity {
    private String name;
    private String address;

    @Enumerated(value = EnumType.STRING)
    private Institution institutionType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hospital> hospitals = new ArrayList<>(0);

    public HealthInstitution(String name, String address, Institution institutionType) {
        this.name = name;
        this.address = address;
        this.institutionType = institutionType;
    }

    public HealthInstitution addHospital(Hospital hospital) {
        this.hospitals.add(hospital);
        return this;
    }
}
