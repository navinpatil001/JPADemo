package com.navin.jpa.repository;

import com.navin.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonSpringDataRepository extends JpaRepository<Person, Long> {

    @Override
    Optional<Person> findById(Long id);

    @Override
    List<Person> findAll();

    @Override
    void deleteById(Long id);

    @Override
    <S extends Person> S save(S s);
}
