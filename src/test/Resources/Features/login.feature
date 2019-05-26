@login
Feature: User should not be able to login successfully
  So he should see error message

  Background:
    Given user is on home page

  Scenario Outline: User should not be able to login
    When user navigates to login page
    And user enters invalid "<email>" and "<password>"
    Then user should not be logged in successfully
    And user should see "<error message>"
    Examples:
      | email                    | password | error message                                                                                           |
      | rus.charuh+100@gmail.com | abcd12   | Login was unsuccessful. Please correct the errors and try again. No customer account found              |
      | rus.charuh+100@gmail.com |          | Login was unsuccessful. Please correct the errors and try again. No customer account found              |
      | rus.charuh+100@gmail.com | test123  | Login was unsuccessful. Please correct the errors and try again. No customer account found              |
      | rus.charuh+7@gmail.com   | abcd12   | Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect |
      | rus.charuh+7@gmail.com   |          | Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect |
      |                          | test123  | Please enter your email                                                                                 |
      |                          |          | Please enter your email                                                                                 |
      |                          | abcd12   | Please enter your email                                                                                 |