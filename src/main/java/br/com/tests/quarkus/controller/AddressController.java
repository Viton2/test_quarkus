package br.com.tests.quarkus.controller;

import br.com.tests.quarkus.model.Address;
import br.com.tests.quarkus.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return service.create(address);
    }

}
