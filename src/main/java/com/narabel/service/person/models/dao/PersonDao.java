package com.narabel.service.person.models.dao;

import com.narabel.service.person.models.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {

}
