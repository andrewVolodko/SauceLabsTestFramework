package testTemplates;

import baseEntitites.BaseTest;
import dataObjects.Credentials;
import dataObjects.CredentialsFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import steps.LoginSteps;
import steps.ProductsSteps;

public abstract class SimpleTestTemplate extends BaseTest {
    protected LoginSteps loginSteps;
    protected ProductsSteps productsSteps;

    protected static final Credentials validUserCreds = CredentialsFactory.loadCredentials().getValidUserCreds();
    protected static final Credentials lockedUserCreds = CredentialsFactory.loadCredentials().getLockedUserCreds();
    protected static final Credentials problemUserCreds = CredentialsFactory.loadCredentials().getProblemUserCreds();
    protected static final Credentials invalidUserCreds = CredentialsFactory.loadCredentials().getInvalidUserCredsCreds();

    @BeforeMethod
    public void setupTemplate() {
        this.loginSteps = new LoginSteps(browserService);
        this.productsSteps = new ProductsSteps(browserService);
    }
}
