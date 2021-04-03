package steps;

import baseEntitites.BaseStep;
import core.BrowserService;
import dataObjects.Credentials;
import pages.LoginPage;
import steps.productPageSteps.ProductsPageSteps;

public class LoginPageSteps extends BaseStep<LoginPage> {

    public LoginPageSteps(BrowserService browserService) {
        super(browserService, LoginPage.class);
    }

    @Override
    public LoginPageSteps open() {
        this.page.open();
        return new LoginPageSteps(browserService);
    }

    public ProductsPageSteps logInWithValidCreds(Credentials creds){
        page.getUsernameInput().sendKeys(creds.getUsername());
        page.getPasswordInput().sendKeys(creds.getPassword());
        page.getLoginBtn().click();

        return new ProductsPageSteps(browserService);
    }

    public LoginPageSteps logInWithInvalidCreds(Credentials creds){
        page.getUsernameInput().sendKeys(creds.getUsername());
        page.getPasswordInput().sendKeys(creds.getPassword());
        page.getLoginBtn().click();

        return new LoginPageSteps(browserService);
    }

    public String getErrorWindowText(){
        return page.getErrorWindow().getText();
    }

}
