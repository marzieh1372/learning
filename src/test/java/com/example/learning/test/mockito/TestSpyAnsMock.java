package com.example.learning.test.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestSpyAnsMock {

    @Mock
    List<String> mockList;
    @Spy
    List<String> spyList = new ArrayList<>();

    @Test
    public void testMockList() {
        mockList.add("Salam");
        System.out.println(mockList.size());
        when(mockList.size()).thenReturn(2);
        assertEquals(2, mockList.size());
    }

    @Test
    public void testSpyList() {
      //  List<String> spyList=Mockito.spy(new ArrayList<>());
        spyList.add("Salam"); //Real method
        Mockito.verify(spyList).add("Salam");
        //System.out.println(spyList.size());
        assertEquals(1, spyList.size());//real method

        doAnswer(invocationOnMock -> 3).when(spyList).size();
         //doReturn(3).when(spyList).size();
         assertEquals(3,spyList.size());//Stubbed method
    }

}
