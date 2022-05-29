package com.example.learning.test.junit5.param;

import com.example.learning.Calculation;
import com.example.learning.StringUtils;
import junit.framework.TestCase;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsingParameterizedTest {


    Calculation calculation = new Calculation();

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, StringUtils.isBlank(input));
    }



    public static int[][] data() {

        return new int[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
    }
    //Check before and after annotations
    @BeforeAll
    public static  void b11(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void a11(){
        System.out.println("AfterAll");
    }
    @BeforeEach
    public  void b1(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    public  void a1(){
        System.out.println("AfterEach");
    }

    @ParameterizedTest
    @MethodSource(value =  "data")
    void testWithStringParameter(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculation.multiply(m1, m2));
    }


    /*
        JUnit will search for a source method with the same name as the test method.
     */
    @ParameterizedTest
    @MethodSource// hmm, no method name ..., method that provide input is eponymous method of testing
    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
        TestCase.assertTrue(Strings.isBlank(input));
    }

    /*
        1- If we're going to provide just one argument per test invocation,
           then it's not necessary to use the Arguments abstraction like above sample
        2- This method's name should like test method
     */

    private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
        return Stream.of(null, "", "  ","salam");
    }

    /*
        we can refer to a source method outside of the current class by its fully qualified name
        FQN#methodName format, we can refer to an external static method.
        method should be static
     */

    @ParameterizedTest
    @MethodSource("com.example.learning.test.param.StringParams#blankStrings")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsExternalSource(String input) {
        assertTrue(Strings.isBlank(input));
    }


    //------------------------------------------ViewSource----------------------------------------------------------
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers (fard)
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(calculation.isOdd(number));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  "})//we can't pass null through a @ValueSource, even for String and Class.
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @NullSource //we can pass a single null value to a parameterized, and for primitive args
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @EmptySource //passes a single empty argument to the annotated method.
    void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource //pass empty and null
    @ValueSource(strings = {"  ", "\t", "\n"})//Combine two data source
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    //-------------------------------------Enum--------------------------------------------
    @ParameterizedTest
    @EnumSource(Month.class) // passing all 12 months
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest //Select custom month
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = EnumSource.Mode.EXCLUDE) //mode attribute to EXCLUDE
    void exceptFourMonths_OthersAre31DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(31, month.length(isALeapYear));
    }


    @ParameterizedTest // regular expression
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    void fourMonths_AreEndingWithBer(Month month) {
        EnumSet<Month> months =
                EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertTrue(months.contains(month));
    }

    //-----------------CSV------------------------------------------------------------------------------

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }

    /*
    When use excel csv you should import data and select delimited
    attribute:
     1- The line separator can be customized using the lineSeparator attribute
     a newline is the default value.
     2- The file encoding is customizable using the encoding attribute — UTF-8 is the default value
     */
    @ParameterizedTest  //If your file is in the test resource folder do not forget to add /
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)// ignore the header column
    // By default does not skip any lines
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
            String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    //-----------------------------------------------------------------------------------

    /*
     Custom Argument Provider
     make the custom provider a more pleasant API to use with a custom annotation.
     see custom annotation in  {com.example.learning.test.junit5.param.customAnnotation.Parameterize2}
  */
    @ParameterizedTest
    @ArgumentsSource(BlankStringsArgumentsProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input) {
        assertTrue(Strings.isBlank(input));
    }

}
