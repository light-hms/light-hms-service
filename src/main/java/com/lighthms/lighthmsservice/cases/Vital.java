package com.lighthms.lighthmsservice.cases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Vital extends BaseEntity {

    @Embedded
    private HeartRate heartRate;

    @Embedded
    private BloodPressure bloodPressure;

    @Embedded
    private OxygenSaturation oxygenSaturation;

    @Embedded
    private Temperature temperature;

    @JsonCreator
    public Vital(HeartRate heartRate, BloodPressure bloodPressure, OxygenSaturation oxygenSaturation, Temperature temperature) {
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.oxygenSaturation = oxygenSaturation;
        this.temperature = temperature;
    }

    @Getter
    @ToString
    @Embeddable
    @NoArgsConstructor
    public static class HeartRate {
        private String rate;

        @JsonCreator
        public HeartRate(String rate) {
            this.rate = rate;
        }
    }

    @Getter
    @ToString
    @Embeddable
    @NoArgsConstructor
    public static class BloodPressure {
        private String pressure;

        @JsonCreator
        public BloodPressure(String pressure) {
            this.pressure = pressure;
        }
    }

    @Getter
    @ToString
    @Embeddable
    @NoArgsConstructor
    public static class OxygenSaturation {
        private String saturation;

        @JsonCreator
        public OxygenSaturation(String saturation) {
            this.saturation = saturation;
        }
    }

    @Getter
    @ToString
    @Embeddable
    @NoArgsConstructor
    public static class Temperature {
        private String temperature;

        @JsonCreator
        public Temperature(String temperature) {
            this.temperature = temperature;
        }
    }
}
