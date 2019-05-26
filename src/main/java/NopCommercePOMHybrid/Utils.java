package NopCommercePOMHybrid;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Utils extends BasePage{

    //Method1 to get all item locators into a String using array
    public static void getStringsIntoArray(int i, int iStart, int iEnd) {
        String[] stringArray = new String[iEnd];
        for (i = iStart; i < iEnd; i++) {
            stringArray[i] = "//div[2]/div[" + (i + 1) + "]/div/div[2]/div[3]/div[1]/span";
            System.out.println(stringArray[i]);
        }
    }

    //Method2 to get all item locators into a String using array
    public static void getStringsIntoArray(String text, int iStart, int iEnd) {
        String[] stringArray = new String[iEnd];
        for (iStart = 0; iStart < iEnd; iStart++) {
            stringArray[iStart] = "//div[2]/div[" + (iStart + 1) + "]/div/div[2]/div[3]/div[1]/span";
            System.out.println(stringArray[iStart]);
        }
    }

    //Reverse array method
    public static void reverseArray(float a[], int n) {
        float[] b = new float[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }

    //1 Clicking element by locator
    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    //1A Clicking element by linkText
    public static void clickElementByLinkText(String link){
        driver.findElement(By.linkText(link)).click();
    }

    //2 Clearing text from a box
    public static void clearBox(By by) {
        driver.findElement(by).clear();
    }

    //3 Entering text into a field
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //4 Clearing the box and then entering text
    public static void clearThenEnterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //5 Checking if WebElement present in DOM
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //6 Checking if WebElement is displayed or not
    public boolean isElementDisplayed(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //7 Wait for fixed time given in seconds
    public static void implicitWait(int timeInSeconds, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, timeUnit);
    }

    //8 Try to click element three times if not available in first go
    public boolean retryForElement(By by) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 3) {
            try {
                sleep(10);
                driver.findElement(by).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempt++;
        }
        return result;
    }

    //9 Wait for locator to be clickable for given time in seconds
    public static void waitForLocatorToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //10 Wait for element to be clickable
    public static void waitForElementToBeClickable(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //11 Wait for for visibility of element with given time
    public static void explicitWaitForVisibility(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //12 Scroll to view element
    public void scrollToElement(By by, WebElement element, int time) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);)", element);
            driver.findElement(by);
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //13 Scroll to element and click
    public static void scrollAndClickBy(By by) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(by);
        js.executeScript("argument[0].scrollIntoView(true);", element);
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }

    //14 Wait for alert to display
    public boolean isAlertPresent() {
        boolean present = false;
        try {
            //Check the presence of alert
            Alert alert = driver.switchTo().alert();
            //Alert present; set the flag
            present = true;
            //If present consume the alert
            alert.accept();
        } catch (NoAlertPresentException ex) {
            //Alert not present
            ex.printStackTrace();
        }
        return present;
    }

    //15 Get attribute of element
    public static String getAttributeOfElementWithWebElement(WebElement element, String attr) {
        String value = element.getAttribute(attr);
        return value;
    }

    //15A Get attribute of element - in class
    public static String getAttributeOfElementWithLocator(By by, String property) {
        String value = driver.findElement(by).getAttribute(property);
        return value;
    }

    //16 Get css property of element
    public String getCssPropertyOfElement(WebElement element, String css) {
        String value = element.getCssValue(css);
        return value;
    }

    //17 Select text from value
    public static String getActualText(By by) {
        String actualText = driver.findElement(by).getText();
        return actualText;
    }

    //18 Select element by visible text
    public static void selectElementByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //19 Select element by value
    public static void selectElementByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    //20 Select element by index
    public static void selectElementByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    //21 Wait for element to be invisible
    public static void waitForElementToBeInvisible(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
    }


    //22 Long date stamp
    public static String dateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("DDMMYYYYSSmmHH");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    //23 Short date stamp
    public static String shortDateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("DDMMHHMM");
        Date date = new Date();
        String date2 = dateFormat.format(date);
        return date2;
    }

    //24 Assert
    public static void assertByGetText(String expectedResult, By by, String errorMessage) {
        Assert.assertEquals(expectedResult, driver.findElement(by).getText(), errorMessage);
    }

    //25 Is Dropdown present
    public static boolean isDropdownMenuPresent(By by, String name) {
        if (driver.findElement(by).getTagName().contains("Select")) {
            return true;
        } else {
            System.out.println("Dropdown menu should not be present");
            return false;
        }
    }

    //26 Get selected value from dropdown
    public static String selectValueFromDropdown(By by) {
        driver.findElement(by).isDisplayed();
        Select dropBox = new Select(driver.findElement(by));
        return dropBox.getFirstSelectedOption().getText();
    }

    //27 Convert date
    public static void getDateToNumeric(String dayMonthYear) {
        DateFormat dateFormat = new SimpleDateFormat();
        Date date = null;
        try {
            date = dateFormat.parse(dayMonthYear);
        } catch (Exception e) {
        }
    }

    //Assert method for assert current url
    public static void assertCurrentURL (String url){
        Assert.assertTrue(driver.getCurrentUrl().equals(url));
    }

    //28 Take screenshot when test fails
    public static void takeAScreenshotWhenTestFails(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("src/test/Screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
}
