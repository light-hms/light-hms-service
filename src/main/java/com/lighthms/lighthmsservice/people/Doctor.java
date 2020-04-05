package com.lighthms.lighthmsservice.people;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Doctor extends BaseEntity {

    private String code;
    private String externalId;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    private String designation;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> specialities = new ArrayList<>(0);
}
