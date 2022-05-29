package com.example.learning.test;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public interface JobService {
    Optional<JobPosition> findCurrentJobPosition(Person person);

    Stream<JobPosition> listJobs(Person person);

    default boolean assignJobPosition(Person person, JobPosition jobPosition) {
        if(!findCurrentJobPosition(person).isPresent()) {
            person.setJobPosition(jobPosition);

            return true;
        } else {
            return false;
        }
    }
}
