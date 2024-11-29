package com.miromori.portifolio.service;

import com.miromori.portifolio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Optional<Person> findById(Long id){
        logger.info("finding one person");

        Person mockedPerson = new Person();
        mockedPerson.setId(counter.incrementAndGet());
        mockedPerson.setFirstName("Leandro");
        mockedPerson.setLastName("Nascimento");
        mockedPerson.setAddress("Uberlandia");
        mockedPerson.setGender("Male");
        return Optional.of(mockedPerson);
    }

    public List<Person> findAll(){
        logger.info("finding all persons");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            people.add(mockPerson(i));
        }
        return people;
    }

    public Person create(Person person){
        logger.info("creating person");
        return person;
    }

    public Person update(Person person){
        logger.info("creating person");
        return person;
    }

    public void delete(Long id){
        logger.info("deleting person");
    }

    private Person mockPerson(int i){
        Person mockedPerson = new Person();
        mockedPerson.setId(counter.incrementAndGet());
        mockedPerson.setFirstName("firstname " + i);
        mockedPerson.setLastName("lastname " + i);
        mockedPerson.setAddress("address " + i);
        mockedPerson.setGender("Male");

        return mockedPerson;
    }
}
