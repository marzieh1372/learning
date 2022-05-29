package com.example.learning.test.junit5.assume;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class TestAssume {

    @Test
    @DisplayName("HassanGholi")
    public void test1() {
        System.out.println(System.getenv("ENV"));
        assumeFalse("Windows".equals(System.getProperty("OS")));
        assertTrue("salam",1==1);
        assumingThat("Windows".equals(System.getProperty("OS")),()->assertTrue("hi",1==1));
    }

}

