package com.bnpparibasfortis.repository;

import com.bnpparibasfortis.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public interface AddressRepository {

    void saveAddress(Address address, Path path) throws IOException;
}
