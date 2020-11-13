package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
    private Logger logger = LogManager.getLogger(HomePage.class);
    WebDriver driver;
    WebDriverWait wait;
    By sellBtnBy = By.xpath("(//div[@id=\"nav-xshop\"]/a)[5]");
    By registryBtnBy = By.xpath("(//div[@id=\"nav-xshop\"]/a)[4]");
    By giftCardsBtnBy = By.xpath("(//div[@id=\"nav-xshop\"]/a)[3]");
    By searchFieldBy = By.id("twotabsearchtextbox");
    By filterCheckboxBy = By.xpath("//div[@id=\"brandsRefinements\"]//i");

    WebElement el;

    public HomePage(WebDriver driver){
        logger.trace("HomePage is initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 1000);
    }
    public HomePage open(){
        logger.info("Open home page");
        driver.get("https://www.amazon.com/");
        wait.until(new ExpectedCondition<Boolean>()) {



            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6;
            }
        });
        return this;
    }

    public HomePage clickSellBtn(){
        logger.info("Click 'Sell' button");
        driver.findElement(sellBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(), 'Sell on Amazon')])[1]")));
        return this;
    }

    public HomePage clickRegistryBtn(){
        logger.info("Click 'Registry' button");
        driver.findElement(registryBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@alt='Register with Amazon']")));
        return this;
    }
    public HomePage clickGiftCardBtn(){
        logger.info("Click 'Gift' button");
        driver.findElement(giftCardsBtnBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text() = 'Gift Cards']")),
                d -> d.findElements(By.xpath("//div[@class='bxc-grid__image   bxc-grid__image--light']")).size()>=3
        ));
        return this;
    }

    public HomePage enterLaptop(){
        logger.info("Enter 'Laptop' into the search field");
        driver.findElement(searchFieldBy).sendKeys("laptop");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@alt='Register with Amazon']")));
        return this;
}
    public HomePage searchText(String searchFor){
    el = driver.findElement(searchFieldBy);
    el.sendKeys(searchFor);
    el.sendKeys(Keys.ENTER);
    return this;
    }
    public HomePage clickCheckbox(){
        logger.info("Click 'Gift' button");
        driver.findElement(filterCheckboxBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@cel_widget_id='MAIN-SEARCH_RESULTS-1']/div")),
                d -> d.findElements(By.xpath("//span[@cel_widget_id='MAIN-SEARCH_RESULTS-1']/div").size()>=3
                        );
        return this;
    }

}
