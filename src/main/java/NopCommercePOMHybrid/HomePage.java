package NopCommercePOMHybrid;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {
    //initialize locator for Register link on home page
    private By _registerLinkOnHomePage = By.xpath("//a[@class='ico-register']");
    //initialize locators for currency dropdown box and for euro currency option
    private By _currencyDropdownBox = By.id("customerCurrency");
    private By _euroCurrencyOption = By.xpath("//option[contains(., 'Euro')]");
    //initialize locators for all four items' prices on home page
    private By _firstItemPriceOnHomePage = By.xpath("//div[2]/div[1]/div/div[2]/div[3]/div[1]/span");
    private By _secondItemPriceOnHomePage = By.xpath("//div[2]/div/div[2]/div[3]/div[1]/span");
    private By _thirdItemPriceOnHomePage = By.xpath("//div[3]/div/div[2]/div[3]/div[1]/span");
    private By _fourthItemPriceOnHomePage = By.xpath("//div[4]/div/div[2]/div[3]/div[1]/span");

    private By _loginPageLink = By.xpath("//a[@class='ico-login']");
    //initialize expected currency sign for verification
    String expectedCurrencySign = "Ђ";

    //method to navigate to register page from home page
    public void navigateToRegisterPage() {
        clickElement(_registerLinkOnHomePage);
    }

    //method to navigate to currency dropdown box and to select euro currency
    public void selectCurrencyFromDropdown() {
        clickElement(_currencyDropdownBox);
        clickElement(_euroCurrencyOption);
    }

    //method to verify currency change by extracting currency sign from four items' prices and
    //asserting them against expected currency sign
    public void verifyCurrencyChange() {
        String actualCurrencySign1 = getActualText(_firstItemPriceOnHomePage).substring(0, 1);
        Assert.assertEquals(expectedCurrencySign, actualCurrencySign1);
        String actualCurrencySign2 = getActualText(_secondItemPriceOnHomePage).substring(0, 1);
        Assert.assertEquals(expectedCurrencySign, actualCurrencySign2);
        String actualCurrencySign3 = getActualText(_thirdItemPriceOnHomePage).substring(0, 1);
        Assert.assertEquals(expectedCurrencySign, actualCurrencySign3);
        String actualCurrencySign4 = getActualText(_fourthItemPriceOnHomePage).substring(0, 1);
        Assert.assertEquals(expectedCurrencySign, actualCurrencySign4);
    }

    public void navigateToCategoryPage(String link) {
        clickElement(By.linkText(link));
    }

    public void navigateToLoginPage() {
        clickElement(_loginPageLink);
    }
}
