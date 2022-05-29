package com.example.learning.test.mockito;

import com.example.learning.test.JobPosition;
import com.example.learning.test.JobService;
import com.example.learning.test.Person;
import com.example.learning.test.UnemployeePerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobServiceUnitTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    UnemployeePerson unemployeePerson;

    /*
     Test Default method in java8 interface
     without implement interface
     In previous version of Mockito get org.mockito.exceptions.base.MockitoException:
     (Cannot call a real method on java interface)
     Note : Jupiter has mockito so you should add mockito core dependency
     */
    @Test
    public void givenDefaultMethod_whenCallRealMethod_thenNoExceptionIsRaised() {
        Person person = new Person();
        when(jobService.findCurrentJobPosition(person))
                .thenReturn(Optional.of(new JobPosition()));

   /*     when(jobService.findCurrentJobPosition(any(Person.class)))
                .thenReturn(Optional.empty());*/ // We can delete this line if we want
        //method return null this value is default

        doCallRealMethod().when(jobService)
                .assignJobPosition(
                        any(Person.class),
                        any(JobPosition.class)
                );

        assertFalse(jobService.assignJobPosition(person, new JobPosition()));
    }

    //******************************************************************************************************************

    @Test
    public void givenDefaultMethod_whenCallRealMethod_thenAssertTrue() {
        Person person = new Person();

        // We can delete this line if we want
        //method return null this value is default
        when(jobService.findCurrentJobPosition(any(Person.class)))
                .thenReturn(Optional.empty());

        doCallRealMethod().when(jobService)
                .assignJobPosition(
                        any(Person.class),
                        any(JobPosition.class)
                );

        assertTrue(jobService.assignJobPosition(person, new JobPosition()));
    }

    //******************************************************************************************************************
    @Test
    public void givenReturnIsOfTypeStream_whenMocked_thenValueIsEmpty() {
        Person person = new Person();
        //Like Option we can delete this line
       // when(jobService.listJobs(any(Person.class))).thenReturn(Stream.empty());

        assertFalse(unemployeePerson.searchJob(person, "").isPresent());
    }
}
