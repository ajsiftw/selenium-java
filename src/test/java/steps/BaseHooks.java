package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;
import utils.Log;

public class BaseHooks {

    @Before
    public void setUp() {
        Log.info("Reached cucumber hook setUp...");
        DriverManager.initializeDriver();
    }

    @After
    public void tearDown() {
        Log.info("Reached cucumber hook tearDown...");
        DriverManager.quitDriver();
    }
}
