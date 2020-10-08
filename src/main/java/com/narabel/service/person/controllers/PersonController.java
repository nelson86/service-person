package com.narabel.service.person.controllers;

import com.narabel.service.person.models.entity.Person;
import com.narabel.service.person.models.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private IPersonService personService;

    @Autowired
    public PersonController( IPersonService personService ) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<Person> list() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person person(@PathVariable Long id) {
        return personService.findById(id);
    }

}
