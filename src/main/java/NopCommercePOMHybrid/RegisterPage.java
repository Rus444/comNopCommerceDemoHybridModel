package NopCommercePOMHybrid;

import org.openqa.selenium.By;

public class RegisterPage extends Utils {
    //LoadProp class object to read data from TestDataConfig file
    LoadProp loadProp = new LoadProp();
    //initialize locators for first name, last name, email address, password and
    // confirm password fields and for register button
    private By _firstNameInputField = By.id("FirstName");
    private By _lastNameInputField = By.id("LastName");
    private By _emailInputField = By.id("Email");
    private By _passwordInputField = By.id("Password");
    private By _confirmPasswordInputField = By.id("ConfirmPassword");
    private By _registerButton = By.name("register-button");

    //method to fill all mandatory fields on registration page
    public void fillAllMandatoryRegistrationDetails() {
        //fetching values from TestDataConfig file for first name
        //last name, email address and password
        String firstName = loadProp.getProperty("firstName");
        String lastName = loadProp.getProperty("lastName");
        String emailAddress = loadProp.getProperty("emailAddress");
        String password = loadProp.getProperty("password");

        //methods to enter the above string values into the relevant fields
        //by using locators initialized earlier and clicking register button
        enterText(_firstNameInputField, firstName);
        enterText(_lastNameInputField, lastName);
        enterText(_emailInputField, emailAddress);
        enterText(_passwordInputField, password);
        enterText(_confirmPasswordInputField, password);
        clickElement(_registerButton);
    }
}
