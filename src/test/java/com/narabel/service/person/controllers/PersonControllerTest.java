package com.narabel.service.person.controllers;

import com.narabel.service.person.models.entity.Person;
import com.narabel.service.person.models.service.IPersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PersonControllerTest {

    @Mock
    IPersonService personService;

    PersonController personController;

    Person personTest1 = new Person(1L, "Nelson", "Test", new Date());
    Person personTest2 = new Person(2L, "Abigail", "Test", new Date());

    @BeforeEach
    void setup() {
        personController = new PersonController(personService);
    }

    @Test
    void list() {
        List<Person> listPersonTest = Arrays.asList(personTest1, personTest2);
        Mockito.when( personService.findAll() ).thenReturn(listPersonTest);

        List<Person> listPerson = personController.list();

        Assertions.assertNotNull(listPerson);
        Assertions.assertEquals(2, listPerson.size());
        Assertions.assertEquals(personTest1, listPerson.get(0));
        Assertions.assertEquals(personTest2, listPerson.get(1));

    }

    @Test
    void person() {
        Mockito.when( personService.findById(1l) ).thenReturn(personTest1);

        Person person = personController.person(1l);
        Assertions.assertEquals(personTest1, person);
    }

}