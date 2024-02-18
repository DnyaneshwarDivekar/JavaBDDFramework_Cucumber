package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import runner.TestRunner;
import utils.ScreenshotUtils;

import java.time.Duration;

public class BaseTest {
	
	
    public static WebDriver driver;
    public WebDriverWait explicitWait;
    public final static int TIMEOUT = 15;
    public final static int Page_Load_Timeout = 30;
 

    public static WebDriver initializeDriver()
    {
    	if (driver==null) {
    		
    			driver = new EdgeDriver();
    	        driver.manage().window().maximize();
    	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Page_Load_Timeout));
    		
    	}
    	
        return driver;
    }

    public static void openPage(String url)
    {
        driver.get(url);
    }

    public static String getCurrentPageUrl()
    {
      return driver.getCurrentUrl();
    }

    public static void tearDown()   
    
    {
    	if (driver!=null) {
    	
        driver.quit();
        
    	}
    }
    
    public static WebDriver getDriver() {
    	
    	return driver;
    }
    
    public static void setDriver1(WebDriver driver1) {
    	
    	driver = driver1;
    }

}
