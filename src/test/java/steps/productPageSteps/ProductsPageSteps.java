package steps.productPageSteps;

import baseEntitites.BaseStep;
import core.BrowserService;
import pages.productsPage.BurgerMenu;
import pages.productsPage.ProductsPage;
import steps.LoginPageSteps;

public class ProductsPageSteps extends BaseStep<ProductsPage> {

    public ProductsPageSteps(BrowserService browserService) {
        super(browserService, ProductsPage.class);
    }

    public String getPageTitleElText(){
        ProductsPage productsPage = new ProductsPage(browserService);

        return productsPage.getPageTitleEl().getText();
    }

    @Override
    public ProductsPageSteps open() {
        this.page.open();
        return new ProductsPageSteps(browserService);
    }

    public BurgerMenu openBurgerMenu(){
        this.page.getBurgerMenuBtn().click();
        while(this.page.getBurgerMenuWrapper().getAttribute("aria-hidden").equals("true")){
            browserService.sleep(500);
        }
        return new BurgerMenu(browserService);
    }

    public LoginPageSteps logOut(){
        openBurgerMenu().getLogOutLink().click();
        return new LoginPageSteps(browserService);
    }
}
