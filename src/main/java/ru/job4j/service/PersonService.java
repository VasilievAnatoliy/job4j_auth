package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.Person;
import ru.job4j.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository persons;

    public PersonService(PersonRepository persons) {
        this.persons = persons;
    }

    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        persons.findAll().forEach(list::add);
        return list;
    }

    public Optional<Person> findById(int id) {
        return this.persons.findById(id);
    }

    public Person save(Person person) {
        return this.persons.save(person);
    }

    public void delete(Person person) {
        this.persons.delete(person);
    }
}
