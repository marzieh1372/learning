package com.example.learning.test.junit5.param;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/*
    Note that an implementation of ArgumentsProvider
    must be declared as either a top-level class or as a static nested class
 */
public class BlankStringsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of((String) null),
                Arguments.of(""),
                Arguments.of("   ")
        );
    }

}
