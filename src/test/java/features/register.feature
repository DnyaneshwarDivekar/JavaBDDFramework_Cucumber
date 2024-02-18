@register @smoke
Feature: Verify that user should be able to register successfully

  Scenario: User should able to register successfully
    Given User navigates to the url "https://dd-demo-tau.vercel.app/register.html"
    When User enters username "DemoUser1" on register page
    And User enters email "dd@gmail.com" on register page
    And User enters password "Pass@123" on register page
    And User clicks on register button
    Then User Registered message should be displayed
