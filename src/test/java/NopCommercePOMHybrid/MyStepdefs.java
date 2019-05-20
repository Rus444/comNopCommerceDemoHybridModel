package NopCommercePOMHybrid;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    //initialize objects of HomePage, RegisterPage and RegistrationSuccessPage classes
    //to call the methods from these classes
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    //Scenario for UserShouldBeAbleToRegisterSuccessfully
    @Given("^user is on register page$")
    public void user_is_on_register_page() {
        homePage.navigateToRegisterPage();
    }

    @When("^user enters all registration details$")
    public void user_enters_all_registration_details() {
        registerPage.fillAllMandatoryRegistrationDetails();
    }

    @Then("^user should be able to register successfully$")
    public void user_should_be_able_to_register_successfully() {
        registrationSuccessPage.userRegisteredSuccessfully();
    }

    //Scenario for changing the currency to euro on home page and for verifying it
    //against the four items' prices at the bottom of the home page
    @Given("^user is on home page$")
    public void userIsOnHomePage() {
    }

    @When("^user selects a currency$")
    public void userSelectsACurrency() {
        homePage.selectCurrencyFromDropdown();
    }

    @Then("^currency sign on prices should change$")
    public void currencySignOnPricesShouldChange() {
        homePage.verifyCurrencyChange();
    }
}
