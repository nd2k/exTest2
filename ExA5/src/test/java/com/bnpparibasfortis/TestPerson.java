package com.bnpparibasfortis;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson {

    private Person person = new Person(1, "John", "Doe", LocalDate.of(1996, 5, 05));

    @Test
    public void calculateAge_personShouldBe24() {

        // arrange
        Integer expected = 24; // 24 years old

        // act
        Integer result = person.calculateAge();

        // assert
        assertThat(result, is(expected));
    }

    @Test
    public void toStringSentenceStartsWithPerson() {

        //arrange
        String expected = "Person";

        //act
        String personToString = person.toString();

        //assert
        assertThat(personToString, startsWith(expected));
    }
}
