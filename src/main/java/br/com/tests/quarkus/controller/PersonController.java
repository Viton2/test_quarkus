package br.com.tests.quarkus.controller;

import br.com.tests.quarkus.model.Person;
import br.com.tests.quarkus.service.PersonService;
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
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Cria uma pessoa")
    public ResponseEntity<Person> create(@RequestBody Person person){
        service.create(person);
        return ResponseEntity.created(URI.create("/persons/"+person.getId())).body(person);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma pessoa")
    public ResponseEntity<Person> getPerson(@PathVariable UUID id){
        Person person = service.getPerson(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    @Operation(summary = "Retorna todas as pessoas")
    public List<Person> getAll(){
        return service.getAll();
    }

}
