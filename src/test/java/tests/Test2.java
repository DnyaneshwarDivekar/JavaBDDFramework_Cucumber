package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Test2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver
     
        driver = new EdgeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if scenario failed
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

}

