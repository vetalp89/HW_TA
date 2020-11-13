package test.java.lesson10;


import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.HomePage;
import test.java.pages.ResultPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TaTest extends TestBaseSetup {
    HomePage homePage;
    ResultPage resultPage;



    @BeforeMethod
    public void pageInitialize(){
        homePage = new HomePage(driver);
        resultPage = new ResultPage(driver);

    }


    @Test{
        //enter the "Laptop" into the search field and press the "Enter" button
        homePage
                .open()
                .enterLaptop()
                .searchText();


        java.util.List<WebElement> searchProducts = driver.findElements();
        for (WebElement el: searchProducts) {
            el.getText().contains();
        }

        String expectedProduct = "HP";
        List<WebElement> actualProduct = searchProducts;
        assertEquals(actualProduct, expectedProduct);
    }



    }
}
