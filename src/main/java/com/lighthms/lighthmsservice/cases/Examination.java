package com.lighthms.lighthmsservice.cases;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Examination extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private ExaminationType examinationType;

    @ElementCollection
    private List<Finding> findings = new ArrayList<>(0);
}
