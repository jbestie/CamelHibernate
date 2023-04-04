package com.fuse.hibernate.example.service;

import com.fuse.hibernate.example.model.Person;

import java.math.BigInteger;
import java.util.List;

public interface PersonService {
    public Person createPerson (Person person);
    public void removePerson (Person person);
    public void removePersonById (BigInteger id);
    public Person findPerson (BigInteger id);
    public List<Person> findPersons();
    public void updateCustomer (Person person);
}
