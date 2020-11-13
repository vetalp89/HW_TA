package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.Screenshots;

public class TestBaseSetup {
    public WebDriver driver;
    By searchFieldBy = By.id("twotabsearchtextbox");

    @BeforeMethod
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        // wait = new WebDriverWait(driver, 10, 500);

    }

    @AfterMethod
    public void finilizeBrowser(ITestResult testResult){
        Screenshots screenshots =  new Screenshots(driver);
        screenshots.makeScreenshot(testResult);
        driver.quit();
    }
}
