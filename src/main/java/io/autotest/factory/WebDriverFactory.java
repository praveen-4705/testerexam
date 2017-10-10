package io.autotest.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;

public class WebDriverFactory {
    @Value("${driver.name:chrome}")
    private String driverName;

    @Value("${webdriver.chrome.driver:ignore}")
    private String chromeDriverLocation;

    public WebDriver createDriver() {
        WebDriver driver;
        switch (driverName) {
            case "chrome":
                driver = initChromeDriver();
                break;
            default:
                throw new IllegalStateException("Specification is not enough to choose driver");
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        if ("ignore".equals(chromeDriverLocation)) {
            throw new IllegalArgumentException("No webdriver.chrome.driver specified to use driver.name=chrome");
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}
