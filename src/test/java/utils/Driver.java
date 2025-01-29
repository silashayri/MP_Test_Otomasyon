package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = System.getProperty("browser", "chrome");
            try {
                switch (browser.toLowerCase()) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        driver.set(new FirefoxDriver(firefoxOptions));
                        break;
                    default:
                        WebDriverManager.chromedriver().browserVersion("stable").setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        driver.set(new ChromeDriver(chromeOptions));
                }
                driver.get().manage().window().maximize();
            } catch (Exception e) {
                System.out.println("Driver oluşturulurken hata: " + e.getMessage());
                throw e;
            }
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
} 