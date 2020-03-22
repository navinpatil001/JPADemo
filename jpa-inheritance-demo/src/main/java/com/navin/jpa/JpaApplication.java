package com.navin.jpa;

import com.navin.jpa.entity.Employee;
import com.navin.jpa.entity.FullTimeEmployee;
import com.navin.jpa.entity.PartTimeEmployee;
import com.navin.jpa.entity.Person;
import com.navin.jpa.repository.EmployeeRepository;
import com.navin.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args){

		/*System.out.println("\n####### Inserting Person  #######");
		personRepository.savePerson(new Person("JAMES","NEWYORK", new Date()));
		personRepository.savePerson(new Person("Nancy","Denmark", new Date()));
		personRepository.savePerson(new Person("Lara","Sydney", new Date()));

		System.out.println("\n####### getPersonbyId 1  #######");
		System.out.println(personRepository.findById(1));

		System.out.println("\n####### update Person having Id = 1  #######");
		System.out.println(personRepository.updatePerson(new Person(1,"JAMES","London",new Date())));

		System.out.println("\n####### getPersonbyId 1  #######");
		System.out.println(personRepository.findById(1));

		System.out.println("\n####### Person All #######");
		System.out.println(personRepository.findAll());*/


		System.out.println("\n####### Inserting Employee #######");
		employeeRepository.saveEmployee(new FullTimeEmployee("John",new BigDecimal(500000)));
		employeeRepository.saveEmployee(new PartTimeEmployee("Henry",new BigDecimal(5000)));

		System.out.println("\n####### Retriving FullTimeEmployees #######");
		System.out.println(employeeRepository.retriveAllFullTimeEmployees());

		System.out.println("\n####### Retriving PartTimeEmployees #######");
		System.out.println(employeeRepository.retriveAllPartTimeEmployees());
	}
}
