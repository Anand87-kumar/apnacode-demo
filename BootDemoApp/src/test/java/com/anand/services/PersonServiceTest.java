package com.anand.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.anand.repo.PersonRepo;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;


    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService = new PersonService(this.personRepo);
    }

    @Test
    void getAllPerson() {
        personService.getAllPerson();
        verify(personRepo).findAll();
    }
}