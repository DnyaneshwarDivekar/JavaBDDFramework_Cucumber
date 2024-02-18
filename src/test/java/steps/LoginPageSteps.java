package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps extends BaseTest {

	private static final Logger logger = LogManager.getLogger(LoginPageSteps.class);

	WebDriver driver = BaseTest.initializeDriver();

	LoginPage loginPage = new LoginPage(driver);

	@Given("User navigates to the url {string}")
	public void user_navigates_to_the_url(String url) {

		openPage(url);
		logger.info("User navigates to the url " + url);

	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {

		loginPage.enterUsername(username);
		logger.info("User enters username : " + username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {

		loginPage.enterPassword(password);
		logger.info("User enters password : " + password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {

		loginPage.clickOnLoginButton();
		logger.info("User clicks on login button");

	}

	@Then("Login Successful message should be displayed")
	public void message_should_be_displayed() {

		// Switch to the alert
		Alert alert = driver.switchTo().alert();

		// Retrieve the text of the alert
		String alertMessage = alert.getText().trim();

		// Accept the alert
		alert.accept();

		Assert.assertEquals(true, alertMessage.contains("Login successful!"));

		logger.info("Login successful message verified");

	}

}
