@textbox @smoke
Feature: Verify that user should be able to test Textbox Test Page

  Scenario: User should able to test Textbox Test Page
    Given User navigates to the url "https://dd-demo-tau.vercel.app/textbox.html"
    When User enters fullname "DemoUser1" on textbox page
    And User enters email "dd@gmail.com" on textbox page
    And User enters current address "Test Address" on textbox page
    And User enters permanent address "Test Address" on textbox page
    And User clicks on submit button
    Then User Submitted Form message should be displayed