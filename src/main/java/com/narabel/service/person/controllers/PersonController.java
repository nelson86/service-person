package com.narabel.service.person.controllers;

import com.narabel.service.person.models.entity.Person;
import com.narabel.service.person.models.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/list")
    public List<Person> list() {
        return personService.findAll();
    }

    @GetMapping("/person/{id}")
    public Person person(@PathVariable Long id) {
        return personService.findById(id);
    }

}
