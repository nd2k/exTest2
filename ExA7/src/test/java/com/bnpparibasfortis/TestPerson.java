package com.bnpparibasfortis;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson {

    private Person person;
    private Person person2;

    @Before
    public void setUp() {
        person = new Person(1, "John", "Doe", LocalDate.of(1996, 5, 05));
        System.out.println("Person object has been created - " + person);
        person2 = new Person(1, "Jane", "Doe", LocalDate.of(2010, 5, 05));
        System.out.println("Person object has been created - " + person2);
    }


    @Test
    public void calculateAge_personShouldBe10() {

        // arrange
        Integer expected = 24; // 24 years old

        // act
        Integer result;
        try {
            result = person.calculateAge();
        } catch (PersonShouldBeAdultException e) {
            return;
        }


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

    @Test(expected = PersonShouldBeAdultException.class)
    public void personShouldBeAnAdult() throws PersonShouldBeAdultException {

        Integer ageHigherOrEqualTo18 = person2.calculateAge();

    }

}
