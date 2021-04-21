package steps.productPageSteps;

import baseEntitites.BaseStep;
import core.BrowserService;
import pages.ProductPage;

public class ProductPageSteps extends BaseStep<ProductPage> {


    public ProductPageSteps(BrowserService browserService) {
        super(browserService, ProductPage.class);
    }

    public String getProductName() {
        return this.page.getProductName().getText();
    }

    @Override
    public ProductPageSteps open() {
        return this;
    }
}
