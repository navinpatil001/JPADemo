package com.navin.jpa.repository;

import com.navin.jpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Person findById(Long id){
        return entityManager.find(Person.class, id);
    }

    @Transactional
    public boolean savePerson(Person person){
        entityManager.persist(person);
        return true;
    }

    public Person findByIdTransaction(Long id){
        return entityManager.find(Person.class, id);
    }

}
