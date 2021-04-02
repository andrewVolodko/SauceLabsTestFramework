package steps;

import baseEntitites.BaseStep;
import core.BrowserService;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps extends BaseStep {
    public LoginSteps(BrowserService browserService) {
        super(browserService);
    }

    public ProductsPage logInWithValidCreds(String username, String password){
        LoginPage loginPage = new LoginPage(browserService);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();

        return new ProductsPage(browserService);
    }

    public LoginPage logInWithInvalidCreds(String username, String password){
        LoginPage loginPage = new LoginPage(browserService);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();

        return new LoginPage(browserService);
    }
}
