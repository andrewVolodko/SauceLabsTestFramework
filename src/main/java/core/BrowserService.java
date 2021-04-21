package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class BrowserService {
    private WebDriver driver;

    public BrowserService() {
        var propertyReader = new PropertiesLoader();

        DriverManagerType driverManagerType;
        switch (propertyReader.getBrowserName().toLowerCase()) {
            case "chrome" -> {
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> driverManagerType = DriverManagerType.FIREFOX;
            case "ie" -> driverManagerType = DriverManagerType.IEXPLORER;
            case "safari" -> driverManagerType = DriverManagerType.SAFARI;
            case "remote" -> driverManagerType = DriverManagerType.SELENIUM_SERVER_STANDALONE;
            case "edge" -> driverManagerType = DriverManagerType.EDGE;
            default -> throw new NoSuchElementException();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
