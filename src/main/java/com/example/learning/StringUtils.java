package com.example.learning;

public class StringUtils {

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
