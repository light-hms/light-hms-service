package com.lighthms.lighthmsservice.cases;

public enum ExaminationType {
    CVS("Cardiovascular (CVS)"),
    RS("Respiratory (RS)");

    private String displayName;

    ExaminationType(String displayName) {
        this.displayName = displayName;
    }
}
