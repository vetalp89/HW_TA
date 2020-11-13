package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.TestBaseSetup;

public class ResultPage extends TestBaseSetup {
    private Logger logger = LogManager.getLogger(HomePage.class);
    WebDriver driver;
    WebDriverWait wait;
    By filterCheckboxBy = By.xpath("//div[@id=\"brandsRefinements\"]//i");
    By brandBy  = By.xpath("//div[@id=\"brandsRefinements\"]//span[@class=\"a-size-base a-color-base a-text-bold\"])[2]");



    public ResultPage(WebDriver driver){
        logger.trace("Page is initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }
    public ResultPage open(){
        logger.trace("Page is opened");
        driver.get("https://www.amazon.com/s?k=laptop&rh=n%3A172282%2Cp_89%3AHP&dc&qid=1605282827&rnid=2528832011&ref=sr_nr_p_89_1");
        wait.until(new ExpectedCondition<Boolean>() {



               public ResultPage filterCheckboxBy(String brand){
        logger.info("Brand of laptop is '" + brand + "'");
        driver.findElement(brandBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(),
                d -> d.findElements(filterCheckboxBy).getText().equals(brand),
                d -> d.findElements().size() >1
        ));
    }
}
