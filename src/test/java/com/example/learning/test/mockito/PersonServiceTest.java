package com.example.learning.test.mockito;

import com.example.learning.mockitoTest.NotFoundPerson;
import com.example.learning.mockitoTest.PersonRepository;
import com.example.learning.mockitoTest.PersonService;
import com.example.learning.test.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    public void findPersonIsNull_thenThrowException(){
        Person person=new Person(2L,"Maryam",null);
        //when(personRepository.findPerson(anyLong())).thenReturn(null);
        doReturn(null).when(personRepository).findPerson(anyLong());
        assertThrows(NotFoundPerson.class,()-> personService.updatePerson(person));
    }


    @Test
    public void test2(){
        Person person=new Person(2L,"Maryam",null);

        when(personRepository.findPerson(anyLong())).thenReturn(null).thenThrow(NullPointerException.class);

       // doThrow(NullPointerException.class).when(personRepository.findPerson(anyLong()));

        //when(personRepository.findPerson(anyLong())).thenReturn(null);
        //doReturn(null).when(personRepository).findPerson(anyLong());
        assertThrows(NotFoundPerson.class,()-> personService.updatePerson(person));
    }
}
