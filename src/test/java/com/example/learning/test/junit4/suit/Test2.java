package com.example.learning.test.junit4.suit;


import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class Test2 {

    @Test
    public void a1(){
        assertTrue("heyyyy",false);
    }

    @Test
    public void a2(){
        assertTrue("horaaaaaaaaa",true);
    }
}
