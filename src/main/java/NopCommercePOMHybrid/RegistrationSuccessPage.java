package NopCommercePOMHybrid;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils {
    //LoadProp class object to read data from TestDataConfig file
    LoadProp loadProp = new LoadProp();
    //initialize locator for actual registration success message
    private By _registrationSuccessMessage = By.xpath("//form/div/div[2]/div[1]");

    //method assert successful registration
    public void userRegisteredSuccessfully() {
        //expected registration success message read from TestDataConfig file
        String expectedRegistrationSuccessMessage = loadProp.getProperty("expectedRegistrationSuccessMessage");
        //actual registration success message read from the registration success page
        String actualRegistrationSuccessMessage = getActualText(_registrationSuccessMessage);
        //asserting expected and actual messages
        Assert.assertEquals(expectedRegistrationSuccessMessage, actualRegistrationSuccessMessage);
    }
}
