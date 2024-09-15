package site.nomoreparties.stellarburgers.pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.pageobject.page.BasePage;

import java.time.Duration;

public class RegisterPage extends BasePage {
    private  final By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");
    private  final By emailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By registerButton= By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButton= By.xpath(".//a[text()='Войти']");

    private final By error = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public  void fillName (String name) {
driver.findElement(nameInput).sendKeys(name);
    }
    public  void fillEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public  void fillPassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public  void clickRegister () {
        driver.findElement(registerButton).click();

    }
    @Step("Click login button")
    public  void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    @Step("Check that validation password error is shown")
    public boolean isErrorShown (){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(error));
        return driver.findElement(error).isDisplayed();
    }

    @Step("Register new user with name email and password")
    public void registerNewUser (String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegister();
    }

}
