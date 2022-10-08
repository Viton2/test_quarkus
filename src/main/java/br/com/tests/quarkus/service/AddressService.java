package br.com.tests.quarkus.service;

import br.com.tests.quarkus.model.Address;
import br.com.tests.quarkus.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }


    public Address create(Address address) {
        return repository.save(address);
    }

    public Address getAddress(UUID id) {
        return repository.getOne(id);
    }

    public List<Address> getAll() {
        return repository.findAll();
    }
}
