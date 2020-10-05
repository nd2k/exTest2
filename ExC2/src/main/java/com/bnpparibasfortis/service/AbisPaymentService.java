package com.bnpparibasfortis.service;

import com.bnpparibasfortis.exception.SalaryTooLowException;
import com.bnpparibasfortis.model.Person;

public class AbisPaymentService implements PaymentService {

    @Override
    public void paySalary(Person person) throws SalaryTooLowException {
        person.calculateNetSalary();
        System.out.println("Paying 1400 euros to John");
    }
}
