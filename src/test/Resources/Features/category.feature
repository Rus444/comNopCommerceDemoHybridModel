@category
Feature: User should be able to navigate to correct category page
  So that he can view all different categories of products

  Background:
    Given user is on home page

  Scenario Outline: User should be able to navigate to category page
    When user clicks on "<category>" page
    Then user should land on "<relevant category page>"
    Examples:
      | category          | relevant category page                         |
      | Computers         | https://demo.nopcommerce.com/computers         |
      | Electronics       | https://demo.nopcommerce.com/electronics       |
      | Apparel           | https://demo.nopcommerce.com/apparel           |
      | Digital downloads | https://demo.nopcommerce.com/digital-downloads |
      | Books             | https://demo.nopcommerce.com/books             |
      | Jewelry           | https://demo.nopcommerce.com/jewelry           |
      | Gift Cards        | https://demo.nopcommerce.com/gift-cards        |