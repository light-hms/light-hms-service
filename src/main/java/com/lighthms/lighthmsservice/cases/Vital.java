package com.lighthms.lighthmsservice.cases;

import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
public class Vital extends BaseEntity {

    @Embedded
    private HeartRate heartRate;

    @Embedded
    private BloodPressure bloodPressure;

    @Embedded
    private OxygenSaturation oxygenSaturation;

    @Embedded
    private Temperature temperature;

    @Embeddable
    public static class HeartRate {
        private String rate;
    }

    @Embeddable
    public static class BloodPressure {
        private String pressure;
    }

    @Embeddable
    public static class OxygenSaturation {
        private String saturation;
    }

    @Embeddable
    public static class Temperature {
        private String temperature;
    }
}
