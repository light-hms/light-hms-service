package com.lighthms.lighthmsservice.cases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class VitalMarshallingTests {

    private ObjectMapper mapper = new ObjectMapper()
            .findAndRegisterModules();


    @Test
    public void serializes() throws JsonProcessingException {
        Vital vital = new Vital(new Vital.HeartRate("72"), new Vital.BloodPressure("80/100"), new Vital.OxygenSaturation("98"), new Vital.Temperature("98.6"));
        String result = mapper.writeValueAsString(vital);
        log.info("Result: {}", result);

        assertThat(result).isNotNull();
    }

    @Test
    public void deSerializes() throws JsonProcessingException {
        String source = "{\n" +
                "  \"heartRate\": {\n" +
                "    \"rate\": \"72\"\n" +
                "  },\n" +
                "  \"bloodPressure\": {\n" +
                "    \"pressure\": \"80/100\"\n" +
                "  },\n" +
                "  \"oxygenSaturation\": {\n" +
                "    \"saturation\": \"98\"\n" +
                "  },\n" +
                "  \"temperature\": {\n" +
                "    \"temperature\": \"98.6\"\n" +
                "  }\n" +
                "}";
        Vital target = mapper.readValue(source, Vital.class);
        log.info("Vital: {}", target);

        assertThat(target).isNotNull();
    }
}
