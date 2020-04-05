package com.lighthms.lighthmsservice.organization;

public enum Institution {
    HOSPITAL("Hospital"),
    CLINIC("Clinic"),
    RURAL("Rural");

    private String displayName;

    Institution(String displayName) {
        this.displayName = displayName;
    }
}
