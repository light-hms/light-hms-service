package com.lighthms.lighthmsservice.cases;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Finding {
    private String key;
    private String value;
    private String displayName;
}
