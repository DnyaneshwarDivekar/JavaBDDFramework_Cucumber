package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	

    //constants
    WebDriver driver;

    //Constructors

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@id='userName']") 
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@id='userEmail']") 
    private WebElement userEmailInput;

    @FindBy(xpath = "//input[@id='password']") 
    private WebElement passwordInput;
    
    @FindBy(xpath = "//button[@type='button']") 
    private WebElement registerButton;
    
 
// User action methods
    
    public void enterUsername(String username)
    {
       usernameInput.sendKeys(username);
         
    }
    
    public void enterEmail(String email)
    {
       userEmailInput.sendKeys(email);
         
    }
    
    public void enterPassword( String password )
    {     
       passwordInput.sendKeys(password);
      
    }
    
    public void clickOnRegisterButton()
    {
          registerButton.click();       
    }
    
    
// E2E user action methods 
    
    public void registerUser(String username, String email, String password)
    {
       usernameInput.sendKeys(username);
       userEmailInput.sendKeys(email);
       passwordInput.sendKeys(password);
       registerButton.click();       
    }

}
