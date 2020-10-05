package com.bnpparibasfortis;

import com.bnpparibasfortis.model.Address;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class TestAddress {


    public Address addressUnderTest = new Address("Rue Java", "555", "7000", "Mons", "Belgique", "BE");
    public Address addressUnderTest2 = new Address("Rue Java Second", "555", "7000", "Mons", "Belgique", "BE");

    @Test
    public void belgianZipCodeShouldBeNumeric() {

        //Arrange
        //boolean expected = true;

        //Act
        boolean result = addressUnderTest.checkZipCodeIsNumeric();

        //Assert
        assertEquals(true, result);
    }

    Path path = Address.getFilePath();

    @Test
    public void addressInAFileExists() throws IOException {
        //arrange
        int counterBeforeWriting = 0;

        //act
        if(Files.exists(path)) {
            path.toFile().setWritable(true);
            counterBeforeWriting = Files.readAllLines(path).size();
        }
        addressUnderTest.writeAddressInAFile();
        int counterAfterWriting = Files.readAllLines(path).size();
        int linesAdded = counterAfterWriting - counterBeforeWriting;
        //assert
        assertEquals(1, linesAdded);
    }

    @Test(expected = IOException.class)
    public void addressInAFileShouldThrowAnException() throws IOException {
        //arrange
        File file = path.toFile();
        if(!Files.exists(path)) {
            file.createNewFile();
        }
        file.setReadOnly();
        addressUnderTest.writeAddressInAFile();
    }

    @Ignore
    @Test
    public void noIdeaYetWhatWeAreGoingToTest() {
        System.out.println("The test has been executed");
    }

}
