package com.miromori.portifolio.service;

import com.miromori.portifolio.exceptions.ResourceNotFoundException;
import com.miromori.portifolio.model.Person;
import com.miromori.portifolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id){
        logger.info("finding one person");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with this ID"));
    }

    public List<Person> findAll(){
        logger.info("finding all persons");
        return repository.findAll();
    }

    public Person create(Person person){
        logger.info("creating person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("creating person");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found with this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("deleting person");
        repository.deleteById(id);
    }

}
