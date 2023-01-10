package com.example.learning.test.mockito;

import com.example.learning.mockitoTest.MathUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CaptorTest {


    @Test
    public void test_Math_Util() {

        MathUtils mockMathUtils = mock(MathUtils.class);
        when(mockMathUtils.add(3, 1)).thenReturn(4);
        when(mockMathUtils.isInteger(anyString())).thenReturn(true);

        ArgumentCaptor acInteger = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor acString = ArgumentCaptor.forClass(String.class);

        assertEquals(4, mockMathUtils.add(3, 1));
        assertTrue(mockMathUtils.isInteger("1"));
        assertTrue(mockMathUtils.isInteger("999"));

        verify(mockMathUtils).add((Integer) acInteger.capture(), (Integer) acInteger.capture());
        List allValues = acInteger.getAllValues();
        assertEquals(Arrays.asList(3, 1), allValues);

        //   verify(mockMathUtils, times(2)).isInteger(acString.capture());
        //  List allStringValues = acString.getAllValues();
        //assertEquals(List.of("1", "999"), allStringValues);
    }


    @Captor
    ArgumentCaptor<Long> acLong;
    //ArgumentCaptor<Long> acLong = ArgumentCaptor.forClass(Long.class);

    //	Need below method if using @Captor annotation or @ExtenWith
/*
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
	}*/


    @Test
    void test_With_Annotation() {
        MathUtils mockMathUtils = mock(MathUtils.class);
        when(mockMathUtils.squareLong(2L)).thenReturn(4L);
        assertEquals(4L, mockMathUtils.squareLong(2L));
        verify(mockMathUtils).squareLong((Long) acLong.capture());
        assertTrue(2 == (long) acLong.getValue());
    }
}
