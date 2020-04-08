package com.lighthms.lighthmsservice.organization;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Hospital extends BaseEntity {
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CareUnit> careUnits = new ArrayList<>(0);

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital addCareUnit(CareUnit careUnit) {
        this.careUnits.add(careUnit);
        return this;
    }
}
