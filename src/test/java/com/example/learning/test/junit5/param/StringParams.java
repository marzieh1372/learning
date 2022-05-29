package com.example.learning.test.junit5.param;

import java.util.stream.Stream;

public class StringParams {

    static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }
}
