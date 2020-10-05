package com.bnpparibasfortis.model;

import com.bnpparibasfortis.exception.PersonShouldBeAdultException;
import com.bnpparibasfortis.exception.SalaryTooLowException;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private int personNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Company company;
    private double grossSalary;

    public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, double grossSalary) {
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.grossSalary = grossSalary;
    }

    public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, double grossSalary, Company company) {
        this(personNumber,firstName,lastName,birthDay, grossSalary);
        this.company = company;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getGrossSalary() { return grossSalary; }

    public void setGrossSalary() { this.grossSalary = grossSalary; }


    @Override
    public String toString() {
        try {
            String text = "Person " + this.personNumber + ": " + this.firstName + " " + this.lastName + " (" + this.calculateAge() + " years old)";
                if (this.company != null) {
                    text += " works for " + this.company.getName() + " in " + this.company.getAddress().getTown() + ".";
                } else {
                    text += " is not employed for the moment.";
                }
            return text;
        } catch (PersonShouldBeAdultException e) {
            return "This person should be an adult";
        }
    }


    public int calculateAge() throws PersonShouldBeAdultException {
        Integer age = Period.between(birthDay, LocalDate.now()).getYears();
        if ( age >= 18) {
            return age;
        } else {
            throw new PersonShouldBeAdultException("This person is not an adult");
        }
    }

    public double calculateNetSalary() throws SalaryTooLowException {
        double netSalary = 0.0;
        netSalary = grossSalary*(1.0-company.calculateTaxToPay()/100.0);
        if(netSalary >= 1500)
            return netSalary;
        else {
            throw new SalaryTooLowException("The net salary in under 1500 euros");
        }
    }
}
