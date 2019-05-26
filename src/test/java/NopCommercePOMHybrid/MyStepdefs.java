package NopCommercePOMHybrid;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class MyStepdefs {
    //initialize objects of HomePage, RegisterPage and RegistrationSuccessPage classes
    //to call the methods from these classes
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
    LoginPage loginPage = new LoginPage();

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


    //Scenario for navigating to different category pages and asserting the url
    @When("^user clicks on \"([^\"]*)\" page$")
    public void user_clicks_on_page(String link) {
        homePage.navigateToCategoryPage(link);
    }

    @Then("^user should land on \"([^\"]*)\"$")
    public void user_should_land_on(String link) {
        Utils.assertCurrentURL(link);
    }


    //Scenario for all negative login variations - user should NOT be logged in
    @When("^user navigates to login page$")
    public void userNavigatesToLoginPage() {
        homePage.navigateToLoginPage();
    }

    @And("^user enters invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersInvalidAnd(String email, String password) {
        loginPage.userEntersCredentialsAndClicksLoginButton(email, password);
    }

    @Then("^user should not be logged in successfully$")
    public void userShouldNotBeLoggedInSuccessfully() {

    }

    @And("^user should see \"([^\"]*)\"$")
    public void userShouldSee(boolean errorMessage) {
        loginPage.getAndAssertErrorMessage(errorMessage);
    }
}
