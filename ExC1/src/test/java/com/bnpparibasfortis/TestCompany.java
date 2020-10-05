package com.bnpparibasfortis;

import com.bnpparibasfortis.model.Address;
import com.bnpparibasfortis.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompany {

    private Address addressUnderTest;
    private Company companyUnderTest;

    @BeforeEach
    public void setUp() {
        addressUnderTest = new Address("rue des Kiévrois", "10", "7000", "Mons", "Belgium", "BE");
        companyUnderTest = new Company("BNP Paribas Fortis", addressUnderTest);
    }

    @Tag("TaxCalculation")
    @DisplayName("A Belgian company should have a tax rate of 51.0%")
    @Test
    public void taxForBelgianCompanyShouldBe51() {

        double expectedTaxToPay = 51.0;

        double taxToPay = companyUnderTest.calculateTaxToPay(addressUnderTest.getCountryCode());

        assertEquals(taxToPay, expectedTaxToPay);
    }
}
