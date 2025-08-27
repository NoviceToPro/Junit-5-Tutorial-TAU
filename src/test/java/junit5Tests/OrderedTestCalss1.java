package junit5Tests;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class OrderedTestCalss1 {

    @BeforeAll
    //we are specifying that we want this method runs before anything of the other method execute
    static void beforeAll(){
        System.out.println("-- This is the before All method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("---- This is the before Each method");
    }

    @AfterAll
     static void afterAll(){
        System.out.println("--This is the after All method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----This is the after Each method");
    }

    @Test
    //accessModifier(cannot be private), returnType(cannot return any value - must be void), nameOfMethod(params)
    void firstMethod(){
        System.out.println("This is the first test method");
    }
    @Test
    @DisplayName("User story123 - TC12- This method is the second one")
    void secondMethod(){
        System.out.println("This is the second test method");
    }
    @Test
    @DisplayName("A display name")
        //accessModifier(cannot be private), returnType(cannot return any value - must be void), nameOfMethod(params)
    void thirdMethod(){
        System.out.println("This is the third test method");
    }

}

