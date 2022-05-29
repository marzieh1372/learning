package com.example.learning.java8;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class TestLazyEvaluation {
    static String eagerMatch(boolean a, boolean b) {
        return (b && a) ? "match" : "incompatible!";
    }

    static String lazyMatch(Supplier<Boolean> a, Supplier<Boolean> b) {
        return (a.get() && b.get()) ? "match" : "incompatible!";
    }

    static boolean compute(String str) {
        System.out.println("executing..."+str);
        // expensive computation here
        return str.contains("a");
    }

    public static void main(String [] args) {
        System.out.println("***************************eagerMatch*******************************");
        System.out.println(eagerMatch(compute("bb"),compute("aa")));
        System.out.println("******************************lazyMatch(bb,aa)****************************");
        System.out.println(lazyMatch(() -> compute("bb"), () -> compute("aa")));
        System.out.println("******************************lazyMatch(aa,bb)****************************");
      //  System.out.println(lazyMatch(() -> compute("aa"), () -> compute("bb")));
        System.out.println("******************************lazyMatch(aa,aa)****************************");
    //    System.out.println(lazyMatch(() -> compute("aa"), () -> compute("aa")));
    }
}
