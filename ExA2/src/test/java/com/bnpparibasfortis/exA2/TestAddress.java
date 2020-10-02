package com.bnpparibasfortis.exA2;

import com.bnpparibasfortis.exA2.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestAddress {


    public Address addressUnderTest = new Address("Rue Java", "555", "7000", "Mons", "Belgique", "BE");

    @Test
    public void belgianZipCodeShouldBeNumeric() {

        //Arrange
        //boolean expected = true;

        //Act
        boolean result = addressUnderTest.checkZipCodeIsNumeric();

        //Assert
        assertEquals(true, result);
    }

}
