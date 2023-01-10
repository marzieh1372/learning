package com.example.learning.mockitoTest;

import com.example.learning.test.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    public Person updatePerson(Person person){
        //Do something
        Person p =new Person();
        p.setName("Mr."+person.getName());
        return p;
    }

    public Person findPerson(long id){
        //Do something
        return new Person(2,"aa",null);
    }
}
