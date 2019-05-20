package NopCommercePOMHybrid;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    //LoadProp class to read data from TestDataConfig file
    LoadProp loadProp = new LoadProp();
    //browser setup method
    public void setUpBrowser() {

        String browser = loadProp.getProperty("browser");

        if (browser.equalsIgnoreCase("firefox")) {

            //Set properties for Firefox Driver
            System.setProperty("webdriver.gecko.driver", "src/test/Resources/BrowserDrivers/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(loadProp.getProperty("url"));
            driver.manage().window().fullscreen();

        } else if (browser.equalsIgnoreCase("chrome")) {

            //Set properties for Chrome Driver
            System.setProperty("webdriver.chrome.driver", "src/test/Resources/BrowserDrivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--diable-extensions");
            options.addArguments("--disbale-setUpBrowser-side-navigation");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
            driver = new ChromeDriver(options);

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(loadProp.getProperty("url"));
            driver.manage().window().fullscreen();

        } else if (browser.equalsIgnoreCase("ie")) {

            //Set properties for IE Driver
            System.setProperty("webdriver.ie.driver", "src/test/Resources/BrowserDrivers/IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            driver = new InternetExplorerDriver(options);

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(loadProp.getProperty("url"));
            driver.manage().window().maximize();
        } else {
            System.out.println("Browser name is empty or typed wrong: " + browser);
        }
    }
}
