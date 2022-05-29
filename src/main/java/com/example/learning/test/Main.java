package com.example.learning.test;

import com.example.learning.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("1","RED"));
        appleList.add(new Apple("2","RED"));
        appleList.add(new Apple("3","GREEN"));
        appleList.add(new Apple("4","YELLOW"));
        List<Apple> result=searchAppleList (appleList,"RED");
        System.out.println(result.size());

        searchAppleListJava8( appleList, (apple)-> apple.getColor().equals("RED"));
    }

    public static List<Apple> searchAppleList (List<Apple> appleList,String color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple1 : appleList){
            if (color.equals(apple1.getColor())){
                result.add(apple1);
            }
        }
        return result;
    }

    public static List<Apple> searchAppleListJava8(List<Apple> appleList, Predicate<Apple> predicate){

        List<Apple> result = new ArrayList<>();
        for (Apple apple1 : appleList){
            if (predicate.test(apple1)){
                result.add(apple1);
            }
        }
        return result;
    }
}
