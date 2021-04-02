package steps;

import baseEntitites.BaseStep;
import core.BrowserService;
import pages.ProductsPage;

public class ProductsSteps extends BaseStep {

    public ProductsSteps(BrowserService browserService) {
        super(browserService);
    }

    public String getPageTitleElText(){
        ProductsPage productsPage = new ProductsPage(browserService);

        return productsPage.getPageTitleEl().getText();
    }
}
