package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testTemplates.SimpleTestTemplate;

public class SmokeTest extends SimpleTestTemplate {

    @Test
    public void validUserLogInTest(){
        loginPageSteps.logInWithValidCreds(validUserCreds);

        Assert.assertEquals(productsPageSteps.getPageTitleElText(), "PRODUCTS");
    }

    @Test
    public void invalidUserLogInTest(){
        loginPageSteps.logInWithInvalidCreds(invalidUserCreds);

        Assert.assertEquals(loginPageSteps.getErrorWindowText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedUserLogInTest(){
        loginPageSteps.logInWithInvalidCreds(lockedUserCreds);

        Assert.assertEquals(loginPageSteps.getErrorWindowText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void validUserLogInLogOutTest(){
        loginPageSteps.logInWithValidCreds(validUserCreds)
                .logOut();

        Assert.assertTrue(loginPageSteps.isOnPage());
    }

    @Test
    public void addProductToShoppingCartTest(){
        var productName = "Sauce Labs Bolt T-Shirt";
        var shoppingCartPage = loginPageSteps.logInWithValidCreds(validUserCreds)
                .addProductToCartByName(productName)
                .openShoppingCart();

        Assert.assertEquals(shoppingCartPage.getShoppingCartItemByName(productName).getTextName(), productName);
    }

    @Test
    public void openProductPageTest(){
        var productName = "Sauce Labs Fleece Jacket";
        var productPage = loginPageSteps.logInWithValidCreds(validUserCreds)
                .openProductPageByName(productName);

        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Fleece Jacket");
    }
}
