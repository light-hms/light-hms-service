package com.lighthms.lighthmsservice.cases;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class CaseEvent extends BaseEntity {
    private String note;

    @OneToOne
    private Vital vital;
}
