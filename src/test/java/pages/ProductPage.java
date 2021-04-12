package pages;

import baseEntitites.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    // Locators
    private static final By btnBackToProductsBy = By.id("back-to-products");
    private static final By productNameBy = By.className("inventory_details_name");


    public ProductPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getBackToProductsBtn().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void open() {
        super.open();
    }

    public WebElement getBackToProductsBtn(){
        return driver.findElement(btnBackToProductsBy);
    }

    public WebElement getProductName(){
        return driver.findElement(productNameBy);
    }
}
