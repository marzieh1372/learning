package com.example.learning.test.junit4;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TestAssertThat {

    @Test
    public void whenCheckingExceptionMessage_thenEqual() {
        try {
           // methodThatShouldThrowException();
            fail("Exception not thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Operation Not Supported", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFailingATest_thenFailed() {
        // Test not completed
        fail("FAIL - test not completed");
    }



    @Test
    public void whenTwoStringsAreEqual_thenCorrect() {
        String first = "hello";
        String second = "Hello";
        assertThat(first, equalToIgnoringCase(second));

    }


    @Test
    public void whenTwoStringsAreEqualWithWhiteSpace_thenCorrect() {
        String first = "hello";
        String second = "   Hello   ";

        assertThat(first, equalToIgnoringWhiteSpace(second));
    }


    @Test
    public void whenStringIsBlank_thenCorrect() {
        String first = "  ";
        String second = null;


        assertThat(second, blankOrNullString());
        assertThat(first, blankOrNullString());
        assertThat(first, blankString());

    }

    @Test
    public void whenStringIsEmpty_thenCorrect() {
        String first = "";
        String second = null;

        assertThat(first, emptyString());
        assertThat(first, emptyOrNullString());
        assertThat(second, emptyOrNullString());
    }

    @Test
    public void whenStringMatchPattern_thenCorrect() {
        String first = "hello";

        assertThat(first, matchesPattern("[a-z]+"));
    }

    @Test
    public void whenVerifyStringContains_thenCorrect() {
        String first = "hello";

        assertThat(first, containsString("lo"));
        assertThat(first, containsStringIgnoringCase("EL"));
    }

    @Test
    public void whenVerifyStringContainsInOrder_thenCorrect() {
        String first = "hello";

        assertThat(first, stringContainsInOrder("e","l","o"));
    }

    @Test
    public void whenVerifyStringStartsWith_thenCorrect() {
        String first = "hello";

        assertThat(first, startsWith("he"));
        assertThat(first, startsWithIgnoringCase("HEL"));
    }


    @Test
    public void whenVerifyStringEndsWith_thenCorrect() {
        String first = "hello";

        assertThat(first, endsWith("lo"));
        assertThat(first, endsWithIgnoringCase("LO"));
    }



}
