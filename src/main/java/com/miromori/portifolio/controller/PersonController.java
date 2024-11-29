package com.miromori.portifolio.controller;

import com.miromori.portifolio.model.Person;
import com.miromori.portifolio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") Long id){
        return personService.findById(id).orElse(null);
    }

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        personService.delete(id);
    }

    public static class CustomizedResponseEntityExceptionHandler {
    }
}
