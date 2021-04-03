package pages.productsPage;

import baseEntitites.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    private static final String PATH = "inventory.html";

    // Locators
    private static final By pageTitleBy = By.className("title");
    private static final By btnBurgerMenuBy = By.id("react-burger-menu-btn");
    private static final By burgerMenuWrapperBy = By.className("bm-menu-wrap");
    private static final By itemProductBy = By.className("inventory_item");

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
    public WebElement getBurgerMenuBtn() {
        return driver.findElement(btnBurgerMenuBy);
    }
    public WebElement getBurgerMenuWrapper() {
        return driver.findElement(burgerMenuWrapperBy);
    }
    public List<WebElement> getAllProducts() {
        return driver.findElements(itemProductBy);
    }
}
