package com.narabel.service.person.models.service;

import com.narabel.service.person.models.entity.Person;

import java.util.List;

public interface IPersonService {

    public List<Person> findAll();
    public Person findById(Long Id);

}
