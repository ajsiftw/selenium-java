package tests.testng;

import org.junit.jupiter.api.*;
import utils.DriverManager;

public class JUnit5BaseTest {

    @BeforeEach
    public void setUp() {
        DriverManager.getDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
