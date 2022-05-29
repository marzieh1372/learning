/*
package com.example.learning.test.mockito;

public class UseMockObject {

    @Test(expected = NullPointerException.class)
    public void whenConfigNonVoidRetunMethodToThrowExWithNewExObj_thenExIsThrown() {
        MyDictionary dictMock = mock(MyDictionary.class);
           //.thenThrow(new NullPointerException("Error occurred"));
        when(dictMock.getMeaning(anyString()))
                .thenThrow(new NullPointerException("Error occurred"));

        dictMock.getMeaning("word");
    }

    @Test(expected = IllegalStateException.class)
    public void whenConfigVoidRetunMethodToThrowEx_thenExIsThrown() {
        MyDictionary dictMock = mock(MyDictionary.class);
        // doThrow(new IllegalStateException("Error occurred"))
        doThrow(IllegalStateException.class)
                .when(dictMock)
                .add(anyString(), anyString());

        dictMock.add("word", "meaning");
    }

}
*/
