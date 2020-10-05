package com.bnpparibasfortis.service;

import com.bnpparibasfortis.exception.SalaryTooLowException;
import com.bnpparibasfortis.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
}
