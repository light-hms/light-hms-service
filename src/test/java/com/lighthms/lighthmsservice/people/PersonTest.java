package com.lighthms.lighthmsservice.people;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void expectValidYears() {
        Person person = new Person("Jon", "Denver", LocalDate.of(1990, 01, 01));
        assertThat(person.age()).isEqualTo(30);
    }

    @Test
    void expectIncorrectAgeToFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Jon", "Denver", LocalDate.of(2021, 01, 01));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Jon", "Denver", LocalDate.of(1919, 01, 01));
        });
    }
}
