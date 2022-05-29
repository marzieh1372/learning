package com.example.learning.test.mockito;

import com.example.learning.test.JobPosition;
import com.example.learning.test.JobService;
import com.example.learning.test.Person;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;

public class CustomAnswerWithLambdaUnitTest {

    @Mock
    JobService jobService;

    /*
    there is no need for the PersonAnswer inner class.
     */
    @Before
    public void init() {
        when(jobService.listJobs(any(Person.class))).then((i) ->
                Stream.of(new JobPosition("Teacher"))
                        .filter(p -> ((Person) i.getArgument(0)).getName().equals("Peter")));
    }
}
