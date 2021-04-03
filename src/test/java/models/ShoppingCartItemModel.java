package models;

import org.openqa.selenium.WebElement;

public class ShoppingCartItemModel {
    private final WebElement name;
    private final WebElement description;
    private final WebElement price;
    private final WebElement removeBtn;
    private final WebElement quantity;

    public ShoppingCartItemModel(WebElement name, WebElement description, WebElement price, WebElement removeBtn, WebElement quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.removeBtn = removeBtn;
        this.quantity = quantity;
    }

    public WebElement getName() {
        return name;
    }
    public String getTextName(){
        return name.getText();
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getRemoveBtn() {
        return removeBtn;
    }

    public WebElement getQuantity() {
        return quantity;
    }
}
