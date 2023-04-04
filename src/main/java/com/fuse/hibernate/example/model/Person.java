package com.fuse.hibernate.example.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Table(name="Person")
public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    private BigInteger id;
    private String name;
    private String city;
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Person()
    {
    }

    public Person(String firstName, String city, String country)
    {
        this.name = firstName;
        this.city = city;
        this.country = country;
    }

    public Person(Person person)
    {
        this (person.name, person.city, person.country);
    }


    @Id
    @SequenceGenerator(name = "PERSON_ID_GENERATOR", sequenceName = "PERSONS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID_GENERATOR")
    @Column(name = "PERSON_ID", nullable = false, length = 8)
    public BigInteger getId()
    {
        return id;
    }

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    @XmlElement
    @Column(name = "PERSON_NAME", nullable = false, length = 40)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlElement
    @Column(name = "ADDRESS_CITY", nullable = false, length = 80)
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @XmlElement
    @Column(name = "ADDRESS_COUNTRY", nullable = false, length = 40)
    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}