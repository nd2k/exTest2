package com.bnpparibasfortis;

import com.bnpparibasfortis.exception.PersonShouldBeAdultException;
import com.bnpparibasfortis.exception.SalaryTooLowException;
import com.bnpparibasfortis.model.Company;
import com.bnpparibasfortis.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

    private Person person;
    private Person person2;

    @Mock
    Company mockCompany;

    @Before
    public void setUp() {
        person = new Person(1, "John", "Doe", LocalDate.of(1996, 5, 05), 5000, mockCompany);
        person2 = new Person(1, "Jane", "Doe", LocalDate.of(2010, 5, 05), 1000, mockCompany);
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

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() throws SalaryTooLowException {
        //arrange
        double expected = 0.49 * 5000;

        //act
        when(mockCompany.calculateTaxToPay()).thenReturn(51.0);
        double netSalary = person.calculateNetSalary();

        //assert
        assertEquals(netSalary, expected, 0.01);
        verify(mockCompany).calculateTaxToPay();
    }

    @Test(expected = SalaryTooLowException.class)
    public void salaryTooLowException() throws SalaryTooLowException {
        when(mockCompany.calculateTaxToPay()).thenReturn(51.0);
        double netSalary = person2.calculateNetSalary();
    }

}
