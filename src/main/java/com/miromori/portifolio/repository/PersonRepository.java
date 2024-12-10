package com.miromori.portifolio.repository;

import com.miromori.portifolio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(Long id);
}
