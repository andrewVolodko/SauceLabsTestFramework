package steps.productPageSteps;

import baseEntitites.BaseStep;
import core.BrowserService;
import pages.productsPage.ProductsPage;
import steps.LoginPageSteps;
import steps.ShoppingCartPageSteps;

import java.util.NoSuchElementException;

public class ProductsPageSteps extends BaseStep<ProductsPage> {

    public ProductsPageSteps(BrowserService browserService) {
        super(browserService, ProductsPage.class);
    }

    public String getPageTitleElText() {
        ProductsPage productsPage = new ProductsPage(browserService);

        return productsPage.getPageTitleEl().getText();
    }

    @Override
    public ProductsPageSteps open() {
        this.page.open();
        return new ProductsPageSteps(browserService);
    }

    public ProductsPageSteps openSideBarMenu() {
        this.page.getBurgerMenuBtn().click();
        while (this.page.getSidebarMenuWrapper().getAttribute("aria-hidden").equals("true")) {
            browserService.sleep(600);
        }
        return new ProductsPageSteps(browserService);
    }

    public LoginPageSteps logOut() {
        openSideBarMenu();
        this.page.getLogOutLink().click();
        return new LoginPageSteps(browserService);
    }

    public ProductsPageSteps addProductToCartByName(String productName) {
        var requiredProduct = this.page.getAllProducts()
                .stream()
                .filter(product -> product.getTextName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product was not found"));
        requiredProduct.getAddToCartBtn().click();

        return new ProductsPageSteps(browserService);
    }

    public ShoppingCartPageSteps openShoppingCart() {
        this.page.getShoppingCartLink().click();
        return new ShoppingCartPageSteps(browserService);
    }

    public ProductPageSteps openProductPageByName(String productName) {
        var requiredProduct = this.page.getAllProducts()
                .stream()
                .filter(product -> product.getTextName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product was not found"));
        requiredProduct.getName().click();

        return new ProductPageSteps(browserService);
    }
}
