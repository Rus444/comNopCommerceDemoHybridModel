@currency
Feature: User should be able to change currency
  So that he can view prices in different currencies

  Scenario: User should be able to change currency
    Given user is on home page
    When user selects a currency
    Then currency sign on prices should change