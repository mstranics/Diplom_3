package site.nomoreparties.stellarburgers.pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.pageobject.page.BasePage;

import java.time.Duration;

public class ForgotPasswordPage extends BasePage {

    private  final By loginButton = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click login button")
    public  void clickLoginButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

}
