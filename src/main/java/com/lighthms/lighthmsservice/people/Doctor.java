package com.lighthms.lighthmsservice.people;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Doctor extends BaseEntity {

    private String code;
    private String externalDoctorId;

    @OneToOne
    private Person person;

    private String designation;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> specialities = new ArrayList<>(0);
}
