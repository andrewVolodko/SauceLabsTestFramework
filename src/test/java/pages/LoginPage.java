package pages;

import baseEntitites.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    private static final By btnLoginBy = By.id("login-button");
    private static final By inputUsernameBy = By.id("user-name");
    private static final By inputPasswordBy = By.id("password");
    private static final By errorWindowBy = By.cssSelector("[data-test=error]");


    public LoginPage(BrowserService browserService) {
        super(browserService);
    }

    public void open() {
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
    public WebElement getErrorWindow() {
        return driver.findElement(errorWindowBy);
    }
}
