package com.navin.jpa.service;

import com.navin.jpa.entity.Person;
import com.navin.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void savePerson(Person person){
        personRepository.savePerson(person);
    }

    public Person findById(Long id){
       return personRepository.findById(id);
    }

    @Transactional
    public void findByIdTransaction(Long id){
         System.out.println(personRepository.findById(id));
         System.out.println(personRepository.findById(id));
    }


}
