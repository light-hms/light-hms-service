package com.lighthms.lighthmsservice.organization;

public enum Department {
    NEURO("Neurology"),
    GASTRO("Gastroenterology"),
    NICU("Neonatal"),
    GENERAL("General");

    private String displayName;

    Department(String displayName) {
        this.displayName = displayName;
    }
}
