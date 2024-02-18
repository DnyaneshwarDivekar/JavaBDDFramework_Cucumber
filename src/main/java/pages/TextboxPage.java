package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextboxPage {
	
	 //constants
    WebDriver driver;

    //Constructors

    public TextboxPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@id='fullName']") 
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@id='userEmail']") 
    private WebElement userEmailInput;
    
    @FindBy(xpath = "//input[@id='currentAddress']") 
    private WebElement currentAddressInput;
    
    @FindBy(xpath = "//input[@id='permanentAddress']") 
    private WebElement permanentAddressInput;
    
    @FindBy(xpath = "//button[@type='button']") 
    private WebElement submitButton;
    
 
// User action methods
    
    public void enterFullName(String fullName)
    {
    	fullNameInput.sendKeys(fullName);
         
    }
    
    public void enterEmail(String email)
    {
    	userEmailInput.sendKeys(email);
         
    }
    
    
    public void enterCurrentAddress(String currentAddress)
    {
    	currentAddressInput.sendKeys(currentAddress);
         
    }
    
    public void enterPermanentAddress(String permanentAddress)
    {
    	permanentAddressInput.sendKeys(permanentAddress);
         
    }
    
    public void clickOnSubmitButton() {
    	
    	submitButton.click();
    }

}
