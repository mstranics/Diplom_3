package site.nomoreparties.stellarburgers.pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.pageobject.page.BasePage;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    public static String URL ="https://stellarburgers.nomoreparties.site";

    private final By loginToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");// кнопка войти в аккаунт

    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    private final By pansButton = By.xpath(".//div[(contains(span/text(),'Булки'))]");
    private final By pansButtonEnabled = By.xpath(".//div[(contains(span/text(),'Булки')) and (contains(@class, 'type_current'))]");

    private final By saucesButton = By.xpath(".//div[(contains(span/text(),'Соусы'))]");
    private final By saucesButtonEnabled = By.xpath(".//div[(contains(span/text(),'Соусы')) and (contains(@class, 'type_current'))]");
    private final By fillingsButton = By.xpath(".//div[(contains(span/text(),'Начинки'))]");
    private final By fillingsButtonEnabled = By.xpath(".//div[(contains(span/text(),'Начинки')) and (contains(@class, 'type_current'))]");
    public MainPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click login to account button")
    public void clickLoginToAccountButton () {
        driver.findElement(loginToAccountButton).click();
    }
    @Step("Check that create order button is shown")
    public boolean isCreateOrderShown(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Click sauces button")
    public void clickSaucesButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(saucesButton).click();
    }
    @Step("Click pans button")
    public void clickPansButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(pansButton).click();
    }
    @Step("Click fillings button")
    public void clickFillingsButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(fillingsButton).click();

    }

    @Step("Check that pans is current tab")
    public boolean isPansEnabled () {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(pansButtonEnabled));
        return driver.findElement(pansButtonEnabled).isEnabled();
      }
    @Step("Check that sauces is current tab")
    public boolean isSaucesEnabled () {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(saucesButtonEnabled));

        return driver.findElement(saucesButtonEnabled).isEnabled();
    }
    @Step("Check that fillings is current tab")
    public boolean isFillingsEnabled () {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(fillingsButtonEnabled));

        return driver.findElement(fillingsButtonEnabled).isEnabled();
    }
}



