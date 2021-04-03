package steps;

import baseEntitites.BaseStep;
import core.BrowserService;
import models.ShoppingCartItemModel;
import org.openqa.selenium.WebElement;
import pages.ShoppingCartPage;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ShoppingCartPageSteps extends BaseStep<ShoppingCartPage> {
    public ShoppingCartPageSteps(BrowserService browserService) {
        super(browserService, ShoppingCartPage.class);
    }

    @Override
    public ShoppingCartPageSteps open() {
        this.page.open();
        return new ShoppingCartPageSteps(browserService);
    }

    public ShoppingCartItemModel getShoppingCartItemByName(String shoppingCartItemName){
        return this.page.getAllShoppingCartItems()
                .stream()
                .filter(item -> item.getTextName().equals(shoppingCartItemName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item was not found"));
    }
}
