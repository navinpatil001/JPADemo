package com.navin.jpa.repository;

import com.navin.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query("Select p From Person p where name like '%100'")
    List<Person> personWithNameLike100();

    @Query(value = "Select * From Person p where name like '%100'", nativeQuery = true)
    List<Person> personWithNameLike100WithNativeQuery();

    @Query(name = "find_all_persons")
    List<Person> personWithNameLike100UsingNativeQuery();
}
