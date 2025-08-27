package junit5Tests;


import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParametizedTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @EmptySource//doesnt work with primitive types
    @NullSource
    @ValueSource(strings = {"firstString", "secondString"} )
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel","bucky,barnes"})
    void csvSource_StringString(String parem1, String param2){
        System.out.println("parem1 = " + parem1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","captain,21,false","bucky,5,true"} )
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);

    }

    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter soldier," + "'bucky,barnes'"})
    void csvSource_StringWithComa(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDifferentDelimeter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource (files = {"C:\\Users\\x473874\\IdeaProjects\\Junit5_Tutorial\\src\\test\\resources\\params\\shoppinglist.csv","C:\\Users\\x473874\\IdeaProjects\\Junit5_Tutorial\\src\\test\\resources\\params\\shoppinglist2.csv"}, numLinesToSkip = 1 )
    void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String UOM, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", UOM = " + UOM + ", provider = " + provider);

    }

    @ParameterizedTest
    //testing using the stream
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);

    }
@ParameterizedTest
@MethodSource(value = "junit5Tests.ParamProvider#sourceStream_StringDouble")
void methodSource_StringDoubleStream(String param1, double param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
}

    @ParameterizedTest
    //testing using doubles and string
    @MethodSource(value = "sourceList_StringDouble")
    void sourceList_StringDouble(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = ");
    }

    List<String> sourceString(){
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(arguments("tomato", 2.0), arguments("Carrot", 4.5) , arguments("cabbage", 7.8));
    }



            //Testing using the list method
    /*@MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);

    }

    List<String> sourceString(){
        //processing done here
    return Arrays.asList("tomato", "carrot", "cabbage");
    }*/

    List<String> sourceStringAsStream(){
        //processing
        return Arrays.asList("beetroot", "apple", "pear");
    }
}
