package com.lighthms.lighthmsservice.people;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lighthms.lighthmsservice.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@NoArgsConstructor
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String phoneNumber;

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber) {
        Assert.isTrue(age(dateOfBirth) > 0 && age(dateOfBirth) < 100, "Incorrect age range");
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public int age() {
        return age(dateOfBirth);
    }

    private int age(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
