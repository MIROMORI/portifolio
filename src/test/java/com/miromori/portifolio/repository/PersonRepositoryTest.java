package com.miromori.portifolio.repository;

import com.miromori.portifolio.model.Person;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    EntityManager entityManager;


    @Test
    @Transactional
    @DisplayName("should get person successfully from db")
    void findByIdSucess(){
        Person person = new Person("evelyn", "beatriz", "paulista", "female");
        person.setId(572L);
        createPerson(person);
        Optional<Person> optional = personRepository.findById(1L);

        assertThat(optional.isPresent()).isTrue();
    }

    @Transactional
    void createPerson(Person person){
        entityManager.merge(person);
    }
}