@login @smoke
Feature: Validate login page is working as expected

  Scenario: User should able to login successfully
    Given User navigates to the url "https://dd-demo-tau.vercel.app/login.html"
    When User enters username "DemoUser1"
    And User enters password "Pass@123"
    And User clicks on login button
    Then Login Successful message should be displayed