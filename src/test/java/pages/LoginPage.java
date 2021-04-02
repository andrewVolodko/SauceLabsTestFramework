package pages;

import baseEntitites.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    protected static final By btnLoginBy = By.id("login-button");
    protected static final By inputUsernameBy = By.id("user-name");
    protected static final By inputPasswordBy = By.id("password");

    public LoginPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    protected void open() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getLoginBtn().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getLoginBtn() {
        return driver.findElement(btnLoginBy);
    }
    public WebElement getUsernameInput() {
        return driver.findElement(inputUsernameBy);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(inputPasswordBy);
    }

}
