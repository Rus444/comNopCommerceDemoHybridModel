package NopCommercePOMHybrid;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Utils {
    //locators for Email and password field and login button on Login page
    private By _emailField = By.id("Email");
    private By _passwordField = By.id("Password");
    private By _loginButton = By.xpath("//input[@value='Log in']");

    //method to enter email, password in the relevant fields and to click login button
    public void userEntersCredentialsAndClicksLoginButton(String email, String password) {
        enterText(_emailField, email);
        enterText(_passwordField, password);
        clickElement(_loginButton);
    }

    //method to check whether either of the error messages "Login was unsuccessful."
    //or "Please enter your email" are present on the page after login attempt
    //and if so, that means test verification (assertion) passed

    public void getAndAssertErrorMessage(boolean errorMessage) {

        boolean errorMessage1 = driver.getPageSource().contains("Login was unsuccessful.");
        boolean errorMessage2 = driver.getPageSource().contains("Please enter your email");

        if (errorMessage1 == true || errorMessage2 == true) {
            errorMessage = true;
        } else {
            errorMessage = false;
        }
        Assert.assertTrue(errorMessage);
    }
}