package com.bnpparibasfortis.testing.testing;

import com.bnpparibasfortis.testing.testing.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPerson {

    private Person person = new Person(1, "John", "Doe", LocalDate.of(1996, 5, 05));

    @Test
    public void calculateAge_personShouldBe24() {

        // arrange
        Integer expected = 24; // 24 years old

        // act
        Integer result = person.calculateAge();

        // assert
        assertEquals(expected, result);
    }

}