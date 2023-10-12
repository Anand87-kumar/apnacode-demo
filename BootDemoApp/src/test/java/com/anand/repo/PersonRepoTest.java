package com.anand.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anand.entites.Person;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PersonRepoTest {


    @Autowired
    private PersonRepo personRepo;

    @Test
   void isPersonExitsById() {
        Person person = new Person(1234, "Anand", "Noida");
        personRepo.save(person);
       Boolean actualResult = personRepo.isPersonExitsById(1234);
       assertThat(actualResult).isTrue();
   }

    @AfterEach
    void tearDown() {
        System.out.println("tearing down");
        personRepo.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("setting up");
    }
}