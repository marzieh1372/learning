package com.example.learning.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UnemployeePerson {
    @Autowired
    JobService jobService;
    public Optional<JobPosition> searchJob(Person person, String searchString) {
        return jobService.listJobs(person)
                .filter((j) -> j.getTitle().contains(searchString))
                .findFirst();
    }
}
