package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driver.get() == null) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--guest");

            options.setExperimentalOption("excludeSwitches",
                    new String[]{"enable-automation"});

            options.setExperimentalOption("useAutomationExtension", false);

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);
            prefs.put("profile.password_manager_ui_enabled", false);

            options.setExperimentalOption("prefs", prefs);

            WebDriver webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();

            driver.set(webDriver);
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
           // driver.get().quit();
           // driver.remove();   // VERY IMPORTANT
        }
    }
}
