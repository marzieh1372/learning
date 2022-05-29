package com.example.learning.test.junit4;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestJunit4 {

    @Test
    public void check1(){
        Integer square = 2 * 2;
        Integer rectangle = 2 * 2;

        assertNotEquals(square, rectangle);
    }
}
