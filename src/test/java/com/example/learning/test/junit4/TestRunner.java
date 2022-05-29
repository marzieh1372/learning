package com.example.learning.test.junit4;

import com.example.learning.test.junit4.TestJunit4;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


//Using javac command we can run test class
public class TestRunner {


    public static void main(String[] args) {

        //Use Junit 4
        Result result = JUnitCore.runClasses(TestJunit4.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("--" + failure.toString());
        }


        System.out.println("**" + result.wasSuccessful());
    }
}
