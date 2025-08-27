package junit5Tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {

   static  Stream<Arguments> sourceStream_StringDouble(){
        //processing
        return Stream.of(arguments("apple", 8.0), arguments("pear", 1.5) , arguments("beetroot", 7.8));
    }
}
