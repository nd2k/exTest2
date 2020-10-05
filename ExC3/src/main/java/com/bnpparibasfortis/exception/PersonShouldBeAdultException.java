package com.bnpparibasfortis.exception;

public class PersonShouldBeAdultException extends Exception {
    public PersonShouldBeAdultException(String errorMessage) {
        super(errorMessage);
    }
}
