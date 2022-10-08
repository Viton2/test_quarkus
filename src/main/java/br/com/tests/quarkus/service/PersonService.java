package br.com.tests.quarkus.service;

import br.com.tests.quarkus.model.Person;
import br.com.tests.quarkus.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }


    public void create(Person person) {
        repository.save(person);
    }

    public Person getPerson(UUID id) {
        return repository.getOne(id);
    }

    public List<Person> getAll() {
        return repository.findAll();
    }
}
