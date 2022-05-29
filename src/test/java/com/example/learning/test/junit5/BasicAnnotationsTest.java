package com.example.learning.test.junit5;

/*import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;*/
import org.junit.Ignore;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasicAnnotationsTest {

    static List<Integer> list = new ArrayList<>();

    //@Before
    @BeforeEach
    public  void  fillList(){
        System.out.println("Fill listtttttttttt");
        list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(100);
    }

    //@After
    @AfterEach
    public void afterMethod(){
        System.out.println("After Methoddddddddddddddddd");
    }

    //@AfterClass
    @AfterAll
    public static void afterClass(){
        System.out.println("After classssssss");
    }

    //@BeforeClass
    @BeforeAll
    public static void beforeClass(){
        System.out.println("Beforeeeeeee classssssssss");
    }




    @Test
    @Disabled
    public void checkLenght(){
        System.out.println("checkLenght 1111");
        assertEquals(list.size(),3);
    }



    @Test
    public void checkLength2(){
        System.out.println("CheckLength222");
        assertEquals(list.size(),3,"Not Equal !!!");
    }

}
