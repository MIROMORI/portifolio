package com.miromori.portifolio.service;

import com.miromori.portifolio.data.vo.v1.PersonVO;
import com.miromori.portifolio.data.vo.v2.PersonVOV2;
import com.miromori.portifolio.exceptions.ResourceNotFoundException;
import com.miromori.portifolio.mapper.PersonMapper;
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

    @Autowired
    private PersonMapper mapper;

    public PersonVO findById(Long id){
        logger.info("finding one person");
        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with this ID"));

        return mapper.personToPersonVO(person);
    }

    public List<PersonVO> findAll(){
        logger.info("finding all persons");
        List<Person> persons = repository.findAll();

        return mapper.personsToPersonVOs(persons);
    }

    public PersonVO create(PersonVO person){
        logger.info("creating person");
        repository.save(mapper.personVOToPerson(person));
        return person;
    }

    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("creating person");
        repository.save(mapper.personVOV2ToPerson(person));
        return person;
    }

    public PersonVO update(PersonVO person){
        logger.info("creating person");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found with this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        Person save = repository.save(entity);

        return mapper.personToPersonVO(save);
    }

    public void delete(Long id){
        logger.info("deleting person");
        repository.deleteById(id);
    }

}
