package com.bnpparibasfortis;

import com.bnpparibasfortis.exception.PersonShouldBeAdultException;
import com.bnpparibasfortis.model.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;


import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
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

    @Nested
    @Tag("AgeCalculationTests")
    @DisplayName("The calculateAge_personShouldBe10() and personShouldBeAnAdult() should be tested")
    public class calculationAgeTests {

        @Tag("PersonShouldBe10CalculationTests")
        @DisplayName("The person should be 10 years old")
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
            assertEquals(result, expected);
        }
        @Tag("PersonShouldBeAnAdultCalculationTests")
        @DisplayName("The person should be an adult")
        @Test
        public void personShouldBeAnAdult() throws PersonShouldBeAdultException {

            //assert
            assertThrows(PersonShouldBeAdultException.class, () -> {
                Integer ageHigherOrEqualTo18 = person2.calculateAge();;
            });

        }
    }

//    @Test
//    public void calculateAge_personShouldBe10() {
//
//        // arrange
//        Integer expected = 24; // 24 years old
//
//        // act
//        Integer result;
//        try {
//            result = person.calculateAge();
//        } catch (PersonShouldBeAdultException e) {
//            return;
//        }
//
//        // assert
//        assertEquals(result, expected);
//    }

    @Test
    public void toStringSentenceStartsWithPerson() {

        //arrange
        String expected = "Person";

        //act
        String personToString = person.toString();

        //assert
        assertThat(personToString, startsWith(expected));
    }

//    @Test
//    public void personShouldBeAnAdult() throws PersonShouldBeAdultException {
//
//        //assert
//        assertThrows(PersonShouldBeAdultException.class, () -> {
//            Integer ageHigherOrEqualTo18 = person2.calculateAge();;
//        });
//
//    }

}
