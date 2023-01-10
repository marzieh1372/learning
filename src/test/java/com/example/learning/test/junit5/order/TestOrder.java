package com.example.learning.test.junit5.order;

import com.example.learning.test.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;

//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(CustomOrder.class)
public class TestOrder {

    List<Person> list = new ArrayList<>();
    List<Person> list2 = new ArrayList<>();

    //@Order(2)
    @Test
    public void db() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }


    @Test
    public void gh() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    //@Order(10)
    @Test
    public void ba() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    //@Order(1)
    @Test
    public void c() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }


}
