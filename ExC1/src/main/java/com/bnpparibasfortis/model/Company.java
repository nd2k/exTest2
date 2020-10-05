package com.bnpparibasfortis.model;

import com.bnpparibasfortis.model.Address;

public class Company {

    private String name;
    private Address address;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double calculateTaxToPay() {
        // initialize return variable
        double taxRate = 0.0;
        // check different cases
        switch(this.address.getCountryCode()) {
            case "BE":
                taxRate = 51.0;
            break;
            case "NL":
                taxRate = 47.0;
            break;
            default:
                taxRate = 35.0;
        }
        // return result
        return taxRate;
    }
}
