package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.ScreenshotUtils;

public class ScreenShotTest {

    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new EdgeDriver();

        // Open a web page
        driver.get("https://www.example.com");

        // Perform actions, assertions, etc.

        // Capture screenshot
        ScreenshotUtils.captureScreenshot(driver, "homepage");

        // Close WebDriver
        driver.quit();
    }
}
