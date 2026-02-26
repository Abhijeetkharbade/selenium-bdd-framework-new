package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static byte[] takeScreenshot(WebDriver driver) {

        if (driver == null) {
            throw new RuntimeException("Driver is null. Cannot take screenshot.");
        }

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    public static void saveScreenshot(WebDriver driver, String fileName)
            throws IOException {

        if (driver == null) {
            throw new RuntimeException("Driver is null. Cannot save screenshot.");
        }

        // Create folder automatically
        Files.createDirectories(Paths.get("target/screenshots"));

        // Add timestamp to avoid overwrite
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Files.copy(src.toPath(),
                Paths.get("target/screenshots/"
                        + fileName + "_" + timestamp + ".png"));
    }
}
