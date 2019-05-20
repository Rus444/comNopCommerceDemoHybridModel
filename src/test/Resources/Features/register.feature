@register
Feature: User should be able to register successfully,
  So that he can use all user features from our website

  Scenario: User should be able to register
    Given user is on register page
    When user enters all registration details
    Then user should be able to register successfully