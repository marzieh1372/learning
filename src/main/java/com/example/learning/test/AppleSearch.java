package com.example.learning.test;

import com.example.learning.Apple;

import java.util.List;

@FunctionalInterface
public interface AppleSearch {
    List<String> searchApples(Apple apple);
}
