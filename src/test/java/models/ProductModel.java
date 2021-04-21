package models;

import org.openqa.selenium.WebElement;

public class ProductModel {
    private final WebElement name;
    private final WebElement description;
    private final WebElement image;
    private final WebElement price;
    private final WebElement addToCartBtn;

    public ProductModel(WebElement name, WebElement description, WebElement image, WebElement price, WebElement addToCartBtn) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.addToCartBtn = addToCartBtn;
    }

    public WebElement getName() {
        return name;
    }

    public String getTextName() {
        return name.getText();
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }
}
