package com.example.learning.test.junit4.suit;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.getMessage());
            System.out.println(failure.getDescription());
        }

        System.out.println(result.getFailureCount());
        System.out.println(result.getRunCount());
        System.out.println( result.wasSuccessful());
    }
}
