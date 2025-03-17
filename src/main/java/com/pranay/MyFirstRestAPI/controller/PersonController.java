package com.pranay.MyFirstRestAPI.controller;

import com.pranay.MyFirstRestAPI.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Objects;

@RestController
public class PersonController
{
    Person person1 = new Person(1L, "Veer","Diwathe","9112611420","harshd@gmail.com","ilovejava");
    Person person2= new Person(2L, "Mukul","Chandak","9112611421","mukul@gmail.com","ilovefootball");
    Person person3 = new Person(3L, "Veer","Rane","9112611422","veerr@gmail.com","ilovett");
    Person person4 = new Person(4L, "Puruvas","Pathak","9112611423","puruvasp@gmail.com","iloveonline");
    Person person5 = new Person(5L, "Tushar","Manglani","9112611424","tushar@gmail.com","ilovedsa");
    Person person6 = new Person(6L, "Prathmesh","Umredkar","9112611425","prathmesh@gmail.com","ilovemoney");

    public List<Person> personList = new ArrayList<>(List.of(person1,person2,person3,person4,person5,person6));

    // http://localhost:8080/all
    @GetMapping("/all")
    public List<Person> getPersonList()
    {
        return personList;
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id")Long id)
    {

        Person person = null;

        for(Person target : personList)
        {
            if(Objects.equals(target.getPersonId(), id))
            {
                person = target;
                break;
            }
        }

        return person;
    }

    @GetMapping("/person")
    public List<Person> getPersonsByName(@RequestParam("firstName") String firstName)
    {
        List<Person> responsePersons = new ArrayList<>();

        for (Person p : personList)
        {
            if(p.getFirstName().compareTo(firstName) == 0)
            {
                responsePersons.add(p);
            }
        }

        return responsePersons;
    }



}
