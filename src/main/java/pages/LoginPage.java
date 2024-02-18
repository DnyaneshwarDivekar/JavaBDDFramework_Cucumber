package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //constants
    WebDriver driver;

    //Constructors

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@id='username']") 
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']") 
    private WebElement passwordInput;
    
    @FindBy(xpath = "//button[@type='button']") 
    private WebElement loginButton;
    
 
// User action methods
    
    public void enterUsername(String username)
    {
       usernameInput.sendKeys(username);
         
    }
    
    public void enterPassword( String password )
    {     
       passwordInput.sendKeys(password);
      
    }
    
    public void clickOnLoginButton()
    {
          loginButton.click();       
    }
    
    
// E2E user action methods 
    
    public void loginUser(String username, String password)
    {
       usernameInput.sendKeys(username);
       passwordInput.sendKeys(password);
       loginButton.click();       
    }
}

