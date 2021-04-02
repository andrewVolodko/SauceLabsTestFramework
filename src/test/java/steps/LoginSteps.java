package steps;

import baseEntitites.BaseStep;
import core.BrowserService;
import dataObjects.Credentials;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps extends BaseStep {
    private final LoginPage loginPage;

    public LoginSteps(BrowserService browserService) {
        super(browserService);
        loginPage = new LoginPage(browserService);
    }

    public LoginSteps open(){
        loginPage.open();
        return this;
    }

    public ProductsPage logInWithValidCreds(Credentials creds){
        loginPage.getUsernameInput().sendKeys(creds.getUsername());
        loginPage.getPasswordInput().sendKeys(creds.getPassword());
        loginPage.getLoginBtn().click();

        return new ProductsPage(browserService);
    }

    public LoginPage logInWithInvalidCreds(Credentials creds){
        loginPage.getUsernameInput().sendKeys(creds.getUsername());
        loginPage.getPasswordInput().sendKeys(creds.getPassword());
        loginPage.getLoginBtn().click();

        return new LoginPage(browserService);
    }

    public String getErrorWindowText(){
        return loginPage.getErrorWindow().getText();
    }
}
