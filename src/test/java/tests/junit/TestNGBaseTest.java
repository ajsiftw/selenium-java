package tests.junit;

import org.testng.annotations.*;
import utils.DriverManager;

public class TestNGBaseTest {

    @BeforeClass
    public void setUp() {
        DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
