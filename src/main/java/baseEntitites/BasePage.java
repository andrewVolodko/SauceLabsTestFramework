package baseEntitites;

import core.BrowserService;
import core.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    private final BrowserService browserService;
    public String baseUrl;

    public BasePage(BrowserService browserService) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();

        this.baseUrl = new PropertiesLoader().getBaseUrl();

        waitForOpen();
    }

    public abstract boolean isPageOpened();

    protected void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < 5){
            browserService.sleep(1000);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if(!isPageOpenedIndicator){
            throw new AssertionError("Page was not opened");
        }
    }
}
