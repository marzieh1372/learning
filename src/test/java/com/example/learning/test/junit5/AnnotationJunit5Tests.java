package com.example.learning.test.junit5;


import org.hamcrest.core.CombinableMatcher;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class AnnotationJunit5Tests {

    @BeforeAll
    public static  void b11(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void a11(){
        System.out.println("AfterAll");
    }
    @BeforeEach
    public  void b1(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    public  void a1(){
        System.out.println("AfterEach");
    }

    @Test
    @RepeatedTest(2)
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals(expected, actual, "failure - byte arrays not same");
    }

    //If we want to assert that two arrays are equals, we can use the assertArrayEquals:
    @Test
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = {'J', 'u', 'n', 'i', 't'};
        char[] actual = "Junit".toCharArray();

        assertArrayEquals(expected, actual);
    }

    //If both arrays are null, the assertion will consider them equal:
    @Test
    public void givenNullArrays_whenAssertingArraysEquality_thenEqual() {
        int[] expected = null;
        int[] actual = null;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertEquals() {
        assertEquals("text5", "text5", "failure - strings are not equal");
    }

    @Test
    public void whenAssertingEquality_thenEqual() {
        float square = 2 * 2;
        float rectangle = 2 * 2;

        assertEquals(square, rectangle);
    }


    //??????????
    /*However, if we want to assert that the actual value differs by a predefined delta from the expected value,
     we can still use the assertEquals but we have to pass the delta value as the third parameter:
    * */
    @Test
    public void whenAssertingEqualityWithDelta_thenEqual() {
        float square = 2 * 2;
        float rectangle = 3 * 2;
        float delta = 2;
        System.out.println(square);
        System.out.println(rectangle);

        assertEquals(square, rectangle, delta);
    }

    @Test
    public void testAssertFalse() {
        assertFalse(false, "failure - should be false");
        //Junit 5
        /*BooleanSupplier condition = () -> 5 > 6;
        assertFalse(condition, "5 is not greater then 6");*/
    }

    @Test
    public void testAssertNotNull() {

        assertNotNull(new Object(), "should not be null");
        //Junit 5
        /*Object dog = new Object();
        assertNotNull(dog, () -> "The dog should not be null");*/
    }

    @Test
    public void testAssertNotSame() {
   /*     Person p1=new Person("a","a","a","30");
        Person p2=new Person("a","a","a","30");
        assertNotSame("should not be same Object", p1, p2);*/
    }

    @Test
    public void testAssertNull() {
        Object obj = null;
        assertNull(obj, "should be null");
        //Junit5
      /*  Object cat = null;
        assertNull(cat, () -> "The cat should be null");*/
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = Integer.valueOf(768);
        assertSame(aNumber, aNumber, "should be same");
        //Junit5
       /* String language = "Java";
        Optional<String> optional = Optional.of(language);
        assertSame(language, optional.get());*/
    }

    // JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        assertThat("fdskfjkba",
                both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems() {

        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    // Core Hamcrest Matchers with assertThat
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("go")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }

    @Test
    public void testAssertTrue() {

        assertTrue(true, "failure - should be true");
        //Junit5
        //assertTrue(5 > 4, "5 is greater the 4");
        //assertTrue(null == null, "null is equal to null");
    }
}
