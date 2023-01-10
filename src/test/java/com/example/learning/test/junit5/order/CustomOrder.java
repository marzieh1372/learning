package com.example.learning.test.junit5.order;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Optional;

public class CustomOrder implements MethodOrderer {

    private Comparator<MethodDescriptor> comparator = Comparator.comparing(MethodDescriptor::getDisplayName);

    @Override
    public void orderMethods(MethodOrdererContext methodOrdererContext) {
       methodOrdererContext.getMethodDescriptors().sort(comparator.reversed());

    }

    @Override
    public Optional<ExecutionMode> getDefaultExecutionMode() {
        return Optional.empty();
    }
}
