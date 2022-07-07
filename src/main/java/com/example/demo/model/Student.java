package com.example.demo.model;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30, message = "Name should have at least two characters")
    private String name;

    private String city;
    @Email
    @UniqueElements(message = "The email is already taken")
    private String email;

    @Past
    private LocalDate dob;
    @Transient

    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String city, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String city, String email, LocalDate dob) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.dob = dob;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Max(value = 18, message = "Students should younger than 18. Recheck birthday")
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
