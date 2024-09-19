package site.nomoreparties.stellarburgers.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    public  String getPageUrl() {
     //  new  WebDriverWait(driver,Duration.ofSeconds(2)).until(ExpectedConditions.)
        return driver.getCurrentUrl();
    }



}
