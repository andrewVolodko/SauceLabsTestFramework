package testTemplates;

import core.BrowserService;
import core.PropertiesLoader;
import dataObjects.Credentials;
import dataObjects.CredentialsFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected BrowserService browserService;
    protected PropertiesLoader propertyReader;

    protected static final Credentials validUserCreds = CredentialsFactory.loadCredentials().getValidUserCreds();


    @BeforeTest
    public void setupTest() {
        propertyReader = new PropertiesLoader();
    }

    @BeforeMethod
    public void setUpMethod() {
        browserService = new BrowserService();
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDownMethod() {
        browserService.getDriver().quit();
        browserService = null;
    }
}
