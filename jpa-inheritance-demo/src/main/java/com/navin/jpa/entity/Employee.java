package com.navin.jpa.entity;

import javax.persistence.*;

// @Entity  // for SINGLE_TABLE, TABLE_PER_CLASS, JOINED Inheritance strategy
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // for SINGLE_TABLE Inheritance strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // // for TABLE_PER_CLASS Inheritance strategy
//@DiscriminatorColumn(name = "EmployeeType") // for SINGLE_TABLE Inheritance strategy
//@Inheritance(strategy = InheritanceType.JOINED) // for JOINED Inheritance strategy
@MappedSuperclass
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
