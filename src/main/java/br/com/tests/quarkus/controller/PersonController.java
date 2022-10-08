package br.com.tests.quarkus.controller;

import br.com.tests.quarkus.model.Person;
import br.com.tests.quarkus.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

//    public Person create()

}
