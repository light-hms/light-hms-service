package com.lighthms.lighthmsservice.cases;

public enum InvestigationType {
    CBC("Blood Count (CBC)"),
    XRAY("X-RAY");

    private String displayName;

    InvestigationType(String displayName) {
        this.displayName = displayName;
    }
}
