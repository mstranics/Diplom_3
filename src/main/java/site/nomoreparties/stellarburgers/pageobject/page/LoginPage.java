package site.nomoreparties.stellarburgers.pageobject.page;

import helpers.UserCreds;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage extends BasePage {

    private final By loginForm= By.xpath(".//h2[text()='Вход']/parent::div/form");
    private final By registerButton= By.xpath(".//a[text()='Зарегистрироваться']");
    private final By restorePassButton= By.xpath(".//a[text()='Восстановить пароль']");
    private  final By emailInput = By.xpath(".//input[@name='name']");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");

    private final By logInButton = By.xpath(".//button[text()='Войти']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public  void clickRegisterButton() {
        driver.findElement(registerButton).click();

    }
    @Step("Click login button")
    public  void clickLogInButton() {
        driver.findElement(logInButton).click();

    }
    @Step("Click restore password button")
    public  void clickRestorePassButton(){
        driver.findElement(restorePassButton).click();
    }
   @Step("Check that login form is shown")
    public boolean isLoginFormShown (){
       new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(loginForm));
        return driver.findElement(loginForm).isDisplayed();
    }

    public void fillEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }
    public void fillPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Login with email and password")
    public void loginWithUser (UserCreds userCreds) {
        fillEmail(userCreds.getEmail());
        fillPassword(userCreds.getPassword());
        clickLogInButton();
    }

}
