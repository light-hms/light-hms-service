package com.lighthms.lighthmsservice.cases;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Investigation extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private InvestigationType investigationType;

    @ElementCollection
    private List<Finding> findings = new ArrayList<>(0);
}
