package com.bnpparibasfortis;

import com.bnpparibasfortis.exception.SalaryTooLowException;
import com.bnpparibasfortis.model.Person;
import com.bnpparibasfortis.service.AbisPaymentService;
import com.bnpparibasfortis.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    private PaymentService paymentService;

    @Mock
    Person mockPerson;

    @Before
    public void setUp() {
       paymentService = new AbisPaymentService();
    }


    @Test(expected = SalaryTooLowException.class)
    public void testPaySalaryThrowsException() throws SalaryTooLowException {
        //arrange
        when(mockPerson.calculateNetSalary()).thenThrow(SalaryTooLowException.class);

        //act
        paymentService.paySalary(mockPerson);
    }
}
