package com.eduardorichards.core.driver;

import java.time.Duration;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.eduardorichards.core.config.ConfigReader;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private static final Map<String, Supplier<WebDriver>> BROWSER_FACTORIES = Map.of(
            "chrome", ChromeDriver::new,
            "firefox", FirefoxDriver::new,
            "edge", EdgeDriver::new);

    private static WebDriver createDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();

        Supplier<WebDriver> factory = BROWSER_FACTORIES.get(browser);
        if (factory == null) {
            throw new RuntimeException("Not supported browser" + browser);
        }

        WebDriver driver = factory.get();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigReader.getImplicitWaitSeconds()));

        return driver;
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            DRIVER.set(createDriver());
        }
        return DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                DRIVER.remove();
            }
        }
    }
}
