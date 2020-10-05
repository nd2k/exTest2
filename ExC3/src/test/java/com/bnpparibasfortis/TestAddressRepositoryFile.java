package com.bnpparibasfortis;

import com.bnpparibasfortis.model.Address;
import com.bnpparibasfortis.repository.AddressRepository;
import com.bnpparibasfortis.repository.AddressRepositoryFile;
import com.bnpparibasfortis.service.AbisPaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestAddressRepositoryFile {

    private AddressRepository addressRepository;

    @Mock
    Address mockAddress;

    @Before
    public void setUp() {
        addressRepository = new AddressRepositoryFile();
    }

    @Test
    public void testSaveAddressToFileWithoutException() throws IOException {
        doNothing().when(mockAddress).writeToFile(any(Path.class));
        addressRepository.saveAddress(mockAddress, Paths.get("testFile.txt"));
        verify(mockAddress).writeToFile(any(Path.class));
    }
}
