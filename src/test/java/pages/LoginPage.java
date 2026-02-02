package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By txtUsername = By.id("userName");
    private static final By txtPassword = By.id("password");
    private static final By btnLogin = By.id("login");
    private static final By btnLogout = By.xpath("//*[@id=\"submit\"]");

    public void open(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }

    public void clickLogout() {
        click(btnLogout);
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(txtUsername) && isDisplayed(txtPassword);
    }

}
