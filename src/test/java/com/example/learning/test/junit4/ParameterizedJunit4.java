package com.example.learning.test.junit4;

import com.example.learning.Calculation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedJunit4 {

    private int firstNumber;
    private int secondNumber;
    private int expectedNumber;
    private Calculation calculation=new Calculation();

    @Before
    public void initialize(){
        System.out.println("Before");
        //calculation = new Calculation();
    }

    public ParameterizedJunit4(int firstNumber, int secondNumber, int expectedNumber) {

        super();
        System.out.println("Constructor");
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedNumber = expectedNumber;
    }

    @Parameterized.Parameters
    public static Collection input(){
        System.out.println("input method");
        return Arrays.asList(new Object[][] {{1,2,3},{3,4,7}});
    }

    @Test
    public void testSumMethod(){
        System.out.println("SumOfNumber : "+expectedNumber);
        assertEquals(expectedNumber,calculation.sum(firstNumber,secondNumber));
    }
}
