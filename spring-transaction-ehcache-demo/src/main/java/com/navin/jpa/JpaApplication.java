package com.navin.jpa;

import com.navin.jpa.entity.Person;
import com.navin.jpa.repository.PersonRepository;
import com.navin.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args){

		System.out.println("############################ JPA Repository ##########################");
		System.out.println("\n####### Inserting Person  #######");
		personService.savePerson(new Person("JAMES","NEWYORK", new Date()));
		personService.savePerson(new Person("Nancy","Denmark", new Date()));
		personService.savePerson(new Person("Lara","Sydney", new Date()));

		//Demo of first level cache
		//System.out.println("\n####### getPersonbyId 1  #######");
		//personService.findByIdTransaction(1L);
	}
}
