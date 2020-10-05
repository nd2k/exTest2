package com.bnpparibasfortis;

import com.bnpparibasfortis.model.Address;
import com.bnpparibasfortis.model.Company;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestCompany {

    private Address addressUnderTest;
    private Company companyUnderTest;

    @Before
    public void setUp() {
        addressUnderTest = new Address("rue des Kiévrois", "10", "7000", "Mons", "Belgium", "BE");
        companyUnderTest = new Company("BNP Paribas Fortis", addressUnderTest);
    }

    @Test
    public void taxForBelgianCompanyShouldBe51() {

        double expectedTaxToPay = 51.0;

        double taxToPay = companyUnderTest.calculateTaxToPay();

        assertThat(expectedTaxToPay, is(taxToPay));
    }
}
