package com.bnpparibasfortis;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({ TestAddress.class, TestPerson.class })
public class TestSuite {

    public void testSuite() {
    }
}
