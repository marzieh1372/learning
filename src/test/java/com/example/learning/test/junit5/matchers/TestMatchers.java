package com.example.learning.test.junit5.matchers;

import com.example.learning.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestMatchers {

    @Mock
    private StringUtils stringUtils;
    @Test
    public void test1(){
       // when(stringUtils.isBlank2("salam")).thenReturn(false);
      //  when(stringUtils.isBlank2("ddd")).thenReturn(false);
        when(stringUtils.isBlank2(contains("yyy"))).thenReturn(false);

        //----------------------------
        given(stringUtils.isBlank2("salam")).willReturn(false);
        then(stringUtils).should().isBlank2("salam") ;
        //----------------------------------

    /*    verify(stringUtils).isBlank2(argThat(x->{
          assertTrue(1==1);
          assertFalse(1!=0);
        }));*/
       // assertFalse(stringUtils.isBlank2("yyykjnb"));
    }
}
