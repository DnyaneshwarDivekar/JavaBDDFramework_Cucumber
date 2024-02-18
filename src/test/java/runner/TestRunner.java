package runner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ScreenshotUtils;


@CucumberOptions(features = "src/test/java/features",
                 glue = {"steps"},
                tags = "@smoke",
                monochrome = true,
                plugin = {"html:target/cucumber-reports/cucumber-html-report.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests

{
	 private static final Logger logger = LogManager.getLogger(TestRunner.class);
	 WebDriver driver;
	
	 @BeforeMethod
	 public void setUp() {
		 
		 if (driver==null) {
		 
		 driver = BaseTest.initializeDriver();
		 logger.info("Web driver initialized...");
		 
		 BaseTest.setDriver1(driver);
		 
		 }
	 }
	 	
	 
	  
	    @After
	    public void tearDown(Scenario scenario) {
	        // Capture screenshot if scenario failed
	        if (scenario.isFailed()) {
	            try {
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", "screenshot");
	                
	                // Capture screenshot
	                ScreenshotUtils.captureScreenshot(driver, "test");
	                
	                logger.info("Screenshot captured...");
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	                
	                logger.error("The error : " + e.getMessage());
	            }
	        }

	        // Quit WebDriver
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	 
	 
	 @AfterClass
	    
	    public void closeBrowser() {
		 
		 System.out.println("close browser");
		 
		 if (driver!=null) {
	    	
	    	BaseTest.tearDown();
	    	logger.info("Web Browser closed..");
	    	
		 }
	    }
	 
}
