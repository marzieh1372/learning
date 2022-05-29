package com.example.learning.test.junit5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class Junit5NewAssertion {

    //The execution of a grouped assertion is interrupted only when one of the executables
    // throws a blacklisted exception (OutOfMemoryError for example).
    @Test
    public void givenMultipleAssertion_whenAssertingAll_thenOK() {
        assertAll(
                "heading",
                () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("Java", "JAVA".toLowerCase(),"Bemiri")
                ,() -> assertEquals("java", "JAVA".toLowerCase())
                ,() -> assertEquals("Java", "JAVA".toLowerCase(),"Doost daram")
        );
    }


    @Test
    public void givenTwoLists_whenAssertingIterables_thenEquals() {
        List<String> al = new ArrayList<>(asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(asList("Java", "Junit", "Test"));
        assertIterableEquals(al, ll);
    }

    @Test
    public void whenAssertingEqualityListOfStrings_thenEqual() {
        List<String> expected = asList("Java", "\\d+", "JUnit");
        List<String> actual = asList("Java", "8520", "JUnit");

        assertLinesMatch(expected, actual);
    }

    @Test
    public void whenAssertingEquality_thenNotEqual() {
        Integer value = 5; // result of an algorithm

        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    public void whenAssertingException_thenThrown() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Exception message");
                }
        );
        assertEquals("Exception message", exception.getMessage());

    }


    @Test
    public void whenAssertingTimeout_thenNotExceeded() {
        assertTimeout(
                ofSeconds(2),
                () -> {
                    // code that requires less then 2 minutes to execute
                    Thread.sleep(1000);
                }
        );
    }

    @Test
    public void whenAssertingTimeoutPreemptivelyt_thenNotExceeded() {
        assertTimeoutPreemptively(
                ofSeconds(2),
                () -> {
                    // code that requires less then 2 minutes to execute
                    //If 2000 result is ---> execution exceeded timeout of 2000 ms by 1 ms
                    Thread.sleep(5000);
                }
        );
    }
}
