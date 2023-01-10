package com.example.learning.mockitoTest;

import com.example.learning.test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void updatePerson(Person person){
        Person findPerson = personRepository.findPerson(person.getId());
        if (findPerson !=null){
            Person updatePerson =personRepository.updatePerson(person);
        }else {
            throw new NotFoundPerson("Ohhhhhhhhhh");
        }
    }
}
