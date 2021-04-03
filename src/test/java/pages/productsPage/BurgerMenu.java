package pages.productsPage;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BurgerMenu extends ProductsPage{

    private static final By linkLogOutBy = By.id("logout_sidebar_link");

    public BurgerMenu(BrowserService browserService) {
        super(browserService);
    }

    public WebElement getLogOutLink(){
        return driver.findElement(linkLogOutBy);
    }

}
