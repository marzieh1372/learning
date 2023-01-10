package com.example.learning.test;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private JobPosition jobPosition;

    public Person(String name) {
        this.name = name;
    }
}
