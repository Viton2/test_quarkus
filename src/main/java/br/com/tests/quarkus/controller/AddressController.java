package br.com.tests.quarkus.controller;

import br.com.tests.quarkus.model.Address;
import br.com.tests.quarkus.service.AddressService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Cria um novo endereco")
    public ResponseEntity<Address> create(@RequestBody Address address){
        service.create(address);
        return ResponseEntity.created(URI.create("/addresses/"+address.getId())).body(address);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um endereco")
    public ResponseEntity<Address> getAddress(@PathVariable UUID id){
        Address address = service.getAddress(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    @Operation(summary = "Retorna todos os enderecos")
    public List<Address> getAll(){
        return service.getAll();
    }

}
