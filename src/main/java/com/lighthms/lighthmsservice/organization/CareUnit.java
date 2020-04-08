package com.lighthms.lighthmsservice.organization;

import com.lighthms.lighthmsservice.BaseEntity;
import com.lighthms.lighthmsservice.people.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class CareUnit extends BaseEntity {
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Department department;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bed> beds = new ArrayList<>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Doctor> oncallDoctors = new ArrayList<>(0);

    public CareUnit(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public CareUnit addBeds(int count) {
        for (int i = 0; i < count; i++) {
            beds.add(new Bed(name + "-" + i));
        }
        return this;
    }
}
