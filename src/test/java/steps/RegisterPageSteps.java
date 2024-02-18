package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterPageSteps extends BaseTest {

	WebDriver driver = BaseTest.initializeDriver();

	RegisterPage registerPage = new RegisterPage(driver);

	@When("User enters username {string} on register page")
	public void user_enters_username_on_register_page(String username) {

		registerPage.enterUsername(username);

	}

	@When("User enters email {string} on register page")
	public void user_enters_email_on_register_page(String email) {

		registerPage.enterEmail(email);
	}

	@When("User enters password {string} on register page")
	public void user_enters_password_on_register_page(String password) {

		registerPage.enterPassword(password);
	}

	@When("User clicks on register button")
	public void user_clicks_on_register_button() {

		registerPage.clickOnRegisterButton();

	}

	@Then("User Registered message should be displayed")
	public void user_registered_message_should_be_displayed() {

		// Switch to the alert
		Alert alert = driver.switchTo().alert();

		// Retrieve the text of the alert
		String alertMessage = alert.getText().trim();

		// Accept the alert
		alert.accept();

		Assert.assertEquals(true, alertMessage.contains("User Registered"));

	}

}
