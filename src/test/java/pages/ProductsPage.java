package pages;

import baseEntitites.BasePage;
import core.BrowserService;

public class ProductsPage extends BasePage {
    public ProductsPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    protected void open() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
