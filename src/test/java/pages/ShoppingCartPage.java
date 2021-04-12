package pages;

import baseEntitites.BasePage;
import core.BrowserService;
import models.ProductModel;
import models.ShoppingCartItemModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends BasePage {
    private static final String PATH = "cart.html";

    // Locators
    private static final By btnCheckoutBy = By.id("checkout");
    private static final By shoppingCartItemBy = By.className("cart_item");
    private static final By shoppingCartItemNameBy = By.className("inventory_item_name");
    private static final By shoppingCartItemDescriptionBy = By.className("inventory_item_desc");
    private static final By shoppingCartItemPriceBy = By.className("inventory_item_price");
    private static final By shoppingCartItemRemoveBtnBy = By.className("cart_button");
    private static final By shoppingCartItemQuantityBy = By.className("cart_quantity");

    public ShoppingCartPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        driver.get(baseUrl + PATH);
        super.open();
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getCheckoutBtn().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getCheckoutBtn(){
        return driver.findElement(btnCheckoutBy);
    }

    public List<ShoppingCartItemModel> getAllShoppingCartItems(){
        return driver.findElements(shoppingCartItemBy).stream()
                .map(productItem -> new ShoppingCartItemModel(
                        productItem.findElement(shoppingCartItemNameBy),
                        productItem.findElement(shoppingCartItemDescriptionBy),
                        productItem.findElement(shoppingCartItemPriceBy),
                        productItem.findElement(shoppingCartItemRemoveBtnBy),
                        productItem.findElement(shoppingCartItemQuantityBy)))
                .collect(Collectors.toList());
    }
}
