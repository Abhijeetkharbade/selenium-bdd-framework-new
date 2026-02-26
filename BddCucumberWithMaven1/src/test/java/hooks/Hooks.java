package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {

        // This will initialize driver because of lazy initialization
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {

            byte[] screenshot =
                ScreenshotUtil.takeScreenshot(driver);

            scenario.attach(
                screenshot,
                "image/png",
                scenario.getName()
            );
        }

        // This will close browser and remove ThreadLocal reference
        DriverFactory.quitDriver();
    }
}