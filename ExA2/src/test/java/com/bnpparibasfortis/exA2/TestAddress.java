package com.bnpparibasfortis.exA2;

import com.bnpparibasfortis.exA2.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestAddress {

    public Address address;

    public void address(Address address) {
        this.address = address;
    }

    public Address addressUnderTest = new Address("Rue Java", "555", "7000", "Mons", "Belgique", "BE");

    @Test
    public void belgianZipCodeShouldBeNumeric() {

        //Arrange
        //boolean expected = true;

        //Act
        boolean result = address.checkZipCodeIsNumeric(address.getZipCode());

        //Assert
        assertEquals(true, result);
    }

}
