package pages;

import baseEntitites.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private static final String PATH = "inventory.html";

    // Locators
    private static final By pageTitleBy = By.className("title");

    public ProductsPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        driver.get(baseUrl + PATH);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getPageTitleEl().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getPageTitleEl(){
        return driver.findElement(pageTitleBy);
    }
}
