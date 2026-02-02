package tests.testng;

import org.junit.*;
import utils.DriverManager;

public class JUnit4BaseTest {

    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
