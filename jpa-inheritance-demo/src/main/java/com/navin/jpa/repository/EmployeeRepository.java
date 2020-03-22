package com.navin.jpa.repository;

import com.navin.jpa.entity.Employee;
import com.navin.jpa.entity.FullTimeEmployee;
import com.navin.jpa.entity.PartTimeEmployee;
import com.navin.jpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public boolean saveEmployee(Employee employee){
        entityManager.persist(employee);
        return true;
    }

    public List<Employee> retriveAllEmployees(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    public List<PartTimeEmployee> retriveAllPartTimeEmployees(){
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retriveAllFullTimeEmployees(){
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

}
