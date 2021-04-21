package testTemplates;

import dataObjects.Credentials;
import dataObjects.CredentialsFactory;
import org.testng.annotations.BeforeMethod;
import steps.LoginPageSteps;
import steps.productPageSteps.ProductsPageSteps;

public abstract class SimpleTestTemplate extends BaseTest {
    protected LoginPageSteps loginPageSteps;
    protected ProductsPageSteps productsPageSteps;

    protected static final Credentials lockedUserCreds = CredentialsFactory.loadCredentials().getLockedUserCreds();
    protected static final Credentials problemUserCreds = CredentialsFactory.loadCredentials().getProblemUserCreds();
    protected static final Credentials invalidUserCreds = CredentialsFactory.loadCredentials().getInvalidUserCredsCreds();

    @BeforeMethod
    public void setupTemplate() {
        this.loginPageSteps = new LoginPageSteps(browserService);
        this.productsPageSteps = new ProductsPageSteps(browserService);
    }
}
