package com.bnpparibasfortis;

import com.bnpparibasfortis.exception.PersonShouldBeAdultException;
import com.bnpparibasfortis.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestPerson {

    private Person person;
    private Person person2;

    @BeforeEach
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
        assertEquals(result, is(expected));
    }

    @Test
    public void toStringSentenceStartsWithPerson() {

        //arrange
        String expected = "Person";

        //act
        String personToString = person.toString();

        //assert
        assertEquals(personToString, startsWith(expected));
    }

    @Test
    public void personShouldBeAnAdult() throws PersonShouldBeAdultException {

        Integer ageHigherOrEqualTo18 = person2.calculateAge();
        //assert
        assertThrows(PersonShouldBeAdultException.class, () -> {
            System.out.println("Test has thrown PersonShouldBeAdultException has expected");
        });

    }

}
