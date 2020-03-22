package com.navin.jpa;

import com.navin.jpa.entity.Person;
import com.navin.jpa.repository.PersonRepository;
import com.navin.jpa.repository.PersonSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonSpringDataRepository personSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args){

		System.out.println("############################ JPA Repository ##########################");
		System.out.println("\n####### Inserting Person  #######");
		personRepository.savePerson(new Person("JAMES","NEWYORK", new Date()));
		personRepository.savePerson(new Person("Nancy","Denmark", new Date()));
		personRepository.savePerson(new Person("Lara","Sydney", new Date()));

		System.out.println("\n####### getPersonbyId 1  #######");
		System.out.println(personRepository.findById(1L));

		System.out.println("\n####### update Person having Id = 1  #######");
		System.out.println(personRepository.updatePerson(new Person(1L,"JAMES","London",new Date())));

		System.out.println("\n####### getPersonbyId 1  #######");
		System.out.println(personRepository.findById(1L));

		System.out.println("\n####### Person All #######");
		System.out.println(personRepository.findAll());


		System.out.println("\n\n############################ SPRING DATA JPA Repository ##########################");

		System.out.println("\n####### Inserting Person  #######");
		personSpringDataRepository.save(new Person("LOGAN","Denmark", new Date()));
		personSpringDataRepository.save(new Person("Paul100","Los Angeles", new Date()));

		System.out.println("\n####### getPersonbyId 4  #######");
		System.out.println(personSpringDataRepository.findById(4L));

		System.out.println("\n####### Person All #######");
		System.out.println(personSpringDataRepository.findAll());

		System.out.println("\n####### Person All applying sorting #######");
		System.out.println(personSpringDataRepository.findAll(Sort.by(Sort.Direction.DESC,"name")));

		System.out.println("\n####### Person All applying Paginaton #######");
		System.out.println("\n####### Person Page first #######");
		PageRequest pageRequest = PageRequest.of(0,2);
		Page<Person> firstPage = personSpringDataRepository.findAll(pageRequest);
		System.out.println(firstPage.getContent());

		System.out.println("\n####### Person Page Second #######");
		Pageable secondRequest = firstPage.nextPageable();
		Page<Person> secondPage = personSpringDataRepository.findAll(secondRequest);
		System.out.println(secondPage.getContent());

		System.out.println("\n####### Persons whose name like 100 #######");
		List<Person> personList = personSpringDataRepository.personWithNameLike100();
		System.out.println(personList);
	}
}
