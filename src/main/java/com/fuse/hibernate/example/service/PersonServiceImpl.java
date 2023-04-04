package com.fuse.hibernate.example.service;

import com.fuse.hibernate.example.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigInteger;
import java.util.List;

public class PersonServiceImpl implements PersonService
{
    private final EntityManager em;

    public PersonServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person createPerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.flush();
        em.getTransaction().commit();
        return person;
    }

    @Override
    public void removePerson(Person person) {
        em.remove(person);
    }

    @Override
    public void removePersonById(BigInteger id) {
        em.remove(em.find(Person.class, id));
    }

    @Override
    public Person findPerson(BigInteger id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findPersons() {
        CriteriaQuery<Person> query = em.getCriteriaBuilder().createQuery(Person.class);
        return em.createQuery(query.select(query.from(Person.class))).getResultList();
    }

    @Override
    public void updateCustomer(Person person) {
        em.merge(person);
    }
}
