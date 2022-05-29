package com.example.learning.test.mockito;

import com.example.learning.test.JobPosition;
import com.example.learning.test.JobService;
import com.example.learning.test.Person;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class ArgumentCustomMatcher {

    @Mock
    JobService jobService;
    @Test
    public void whenPersonWithJob_thenIsNotEntitled() {
        Person peter = new Person("Peter");
        Person linda = new Person("Linda");

        JobPosition teacher = new JobPosition("Teacher");

        when(jobService.findCurrentJobPosition(
                ArgumentMatchers.argThat(p -> p.getName().equals("Peter"))))
                .thenReturn(Optional.of(teacher));

       // assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(linda));
       // assertFalse(unemploymentService.personIsEntitledToUnemploymentSupport(peter));
    }
}
