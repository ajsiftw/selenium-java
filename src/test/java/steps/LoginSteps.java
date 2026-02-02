package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverManager;
import utils.ConfigReader;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("User opens URL")
    public void user_opens_url() {
        loginPage.open(ConfigReader.getProperty("loginUrl"));
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    }

    @When("User clicks login")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(DriverManager.getDriver().getTitle(), title);
    }

    @When("User clicks on logout link")
    public void user_clicks_on_logout_link() {
        loginPage.clickLogout();
    }

    @Given("User opens URL {string}")
    public void user_opens_url_login_url(String url) {
        loginPage.open(url);
    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        loginPage.login(username, password);
    }

}