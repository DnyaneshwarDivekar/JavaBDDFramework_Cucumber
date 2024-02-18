package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        // Convert WebDriver object to TakeScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as file
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // Define screenshot destination path
        Path destPath = Paths.get("screenshots", screenshotName + ".png");

        try {
            // Save screenshot to the destination path
            Files.createDirectories(destPath.getParent());
            Files.move(srcFile.toPath(), destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
