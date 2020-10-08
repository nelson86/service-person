package com.narabel.service.person.models.service;

import com.narabel.service.person.models.dao.PersonDao;
import com.narabel.service.person.models.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    private PersonDao personDao;

    @Autowired
    public PersonServiceImpl( PersonDao dao ) {
        this.personDao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Person findById(Long Id) {
        return personDao.findById(Id).orElse(null);
    }
}
