package tests.junit;

import org.junit.jupiter.api.*;
import utils.DriverManager;

public class JUnit5BaseTest {

//    JUnit 4	       JUnit 5 (Jupiter)	Explanation
//    @Test	           @Test	            Marks a method as a test case.
//    @Ignore	       @Disabled	        Skips the execution of a test or class.
//    @Before	       @BeforeEach	        Runs before every individual test method.
//    @After	       @AfterEach	        Runs after every individual test method.
//    @BeforeClass     @BeforeAll	        Runs once before all tests in the class (must be static).
//    @AfterClass      @AfterAll	        Runs once after all tests in the class (must be static).

    @BeforeEach
    public void setUp() {
        DriverManager.getDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
