package com.bnpparibasfortis;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson {

    @Before
    public

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
        String[] arrayPersonIntoString = (person.toString()).split(" ");
        String firstWord = arrayPersonIntoString[0];

        //assert
        assertThat(expected, is(firstWord));
    }
}
