package com.bnpparibasfortis.repository;

import com.bnpparibasfortis.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public class AddressRepositoryFile implements AddressRepository{

    @Override
    public void saveAddress(Address address, Path path) throws IOException {
        address.writeToFile(path);
    }
}
