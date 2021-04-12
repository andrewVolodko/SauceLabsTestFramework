package pages;

import baseEntitites.BasePage;
import core.BrowserService;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    private static final String PATH = "inventory.html";

    // Locators
    private static final By pageTitleBy = By.className("title");
    private static final By btnBurgerMenuBy = By.id("react-burger-menu-btn");
    private static final By sidebarMenuWrapperBy = By.className("bm-menu-wrap");
    private static final By linkShoppingCartBy = By.id("shopping_cart_container");
    private static final By linkLogOutBy = By.id("logout_sidebar_link");


    private static final By productItemBy = By.className("inventory_item");
    private static final By productNameBy = By.className("inventory_item_name");
    private static final By productDescriptionBy = By.className("inventory_item_desc");
    private static final By productImageBy = By.cssSelector("div.inventory_item_img");
    private static final By productPriceBy = By.className("inventory_item_price");
    private static final By productAddToCartBtnBy = By.className("btn_inventory");

    public ProductsPage(BrowserService browserService) {
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
            return getPageTitleEl().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getPageTitleEl() {
        return driver.findElement(pageTitleBy);
    }

    public WebElement getBurgerMenuBtn() {
        return driver.findElement(btnBurgerMenuBy);
    }

    public WebElement getLogOutLink(){
        return driver.findElement(linkLogOutBy);
    }

    public WebElement getSidebarMenuWrapper() {
        return driver.findElement(sidebarMenuWrapperBy);
    }

    public List<ProductModel> getAllProducts() {
        return driver.findElements(productItemBy).stream()
                .map(productItem -> new ProductModel(
                        productItem.findElement(productNameBy),
                        productItem.findElement(productDescriptionBy),
                        productItem.findElement(productImageBy),
                        productItem.findElement(productPriceBy),
                        productItem.findElement(productAddToCartBtnBy)))
                .collect(Collectors.toList());
    }

    public WebElement getShoppingCartLink() {
        return driver.findElement(linkShoppingCartBy);
    }
}
