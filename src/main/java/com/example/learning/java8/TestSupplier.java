package com.example.learning.java8;

import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {
        String str = "Java8";
        Supplier<String> strS3= TestSupplier::testRefrencMethod;
        Supplier<String> strS= ()-> str.toUpperCase();
        Supplier<Integer> strS2= ()-> str.length();
        System.out.println(strS.get());
        System.out.println(strS2.get());
    }

    public static String testRefrencMethod(){
        return "Hi";
    }

    public static void x (Supplier y){

    }
}
