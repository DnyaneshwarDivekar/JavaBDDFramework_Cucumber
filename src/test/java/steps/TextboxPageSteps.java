package steps;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TextboxPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextboxPageSteps extends BaseTest {
	
    private static final Logger logger = LoggerFactory.getLogger(TextboxPageSteps.class);

	WebDriver driver = BaseTest.initializeDriver();
	
	TextboxPage textboxPage = new TextboxPage(driver);
	
	
	@When("User enters fullname {string} on textbox page")
	public void user_enters_fullname_on_textbox_page(String fullName) {
		
		 textboxPage.enterFullName(fullName);
		 logger.info("User enters username : " + fullName);
		
	}

	@When("User enters email {string} on textbox page")
	public void user_enters_email_on_textbox_page(String email) {
		
		 textboxPage.enterEmail(email);
		 logger.info("User enters email : " + email);

	}

	@When("User enters current address {string} on textbox page")
	public void user_enters_current_address_on_textbox_page(String currentAddress) {

		 textboxPage.enterCurrentAddress(currentAddress);
		 logger.info("User enters current address : " + currentAddress);
		
	}

	@When("User enters permanent address {string} on textbox page")
	public void user_enters_permanent_address_on_textbox_page(String permanentAddress) {

		textboxPage.enterPermanentAddress(permanentAddress);
		logger.info("User enters permanent address : " + permanentAddress);
		
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {

		textboxPage.clickOnSubmitButton();
		 logger.info("User clicks on Submit button");
		
	}

	@Then("User Submitted Form message should be displayed")
	public void user_submitted_form_message_should_be_displayed() {


		// Switch to the alert
		Alert alert = driver.switchTo().alert();

		// Retrieve the text of the alert
		String alertMessage = alert.getText().trim();

		// Accept the alert
		alert.accept();

		Assert.assertEquals(true, alertMessage.contains("Submitted Form"));
		logger.info("User Submitted Form...");

	}


}
