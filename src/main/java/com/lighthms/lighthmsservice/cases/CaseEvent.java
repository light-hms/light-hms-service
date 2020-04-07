package com.lighthms.lighthmsservice.cases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class CaseEvent extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Vital vital;

    private String note;


    @JsonCreator
    public CaseEvent(Vital vital, String note) {
        this.vital = vital;
        this.note = note;
    }

    public CaseEvent(Vital vital) {
        this(vital, null);
    }



}
