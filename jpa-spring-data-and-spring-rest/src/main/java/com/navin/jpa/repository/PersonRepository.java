package com.navin.jpa.repository;

import com.navin.jpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(Long id){
        return entityManager.find(Person.class, id);
    }

    public boolean savePerson(Person person){
        entityManager.persist(person);
        return true;
    }

    public boolean updatePerson(Person person){
        entityManager.merge(person);
        return true;
    }

    public boolean deletePersonById(Long id){
        Person person = findById(id);
        entityManager.remove(person);
        return true;
    }

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

}
