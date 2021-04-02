package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testTemplates.SimpleTestTemplate;

public class SmokeTest extends SimpleTestTemplate {

    @Test
    public void validUserLogInTest(){
        loginSteps.open().logInWithValidCreds(validUserCreds);

        Assert.assertEquals(productsSteps.getPageTitleElText(), "PRODUCTS");
    }

    @Test
    public void invalidUserLogInTest(){
        loginSteps.open().logInWithInvalidCreds(invalidUserCreds);

        Assert.assertEquals(loginSteps.getErrorWindowText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
