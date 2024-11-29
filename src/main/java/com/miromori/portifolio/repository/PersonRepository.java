package com.miromori.portifolio.repository;

import com.miromori.portifolio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
