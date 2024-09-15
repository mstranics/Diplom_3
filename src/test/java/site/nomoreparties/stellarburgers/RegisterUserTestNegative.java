package site.nomoreparties.stellarburgers;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.fragment.HeaderFragment;
import site.nomoreparties.stellarburgers.pageobject.page.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;
import site.nomoreparties.stellarburgers.pageobject.page.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterUserTestNegative extends BaseTest{
    Faker faker = new Faker();


    private String email;
    private String name;
    private String password;



    @Test
    @DisplayName("User can't be registered with password <6")
    public void userNotRegisteredPassValidation (){

        LoginPage loginPage = new LoginPage(driver);
        HeaderFragment headerFragment = new HeaderFragment(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        headerFragment.clickAccountButton();
        loginPage.clickRegisterButton();
name=faker.name().username();
email=faker.internet().emailAddress();
password=faker.internet().password(4,5);
        registerPage.registerNewUser(name,email,password);
        assertTrue("нужная ошибка не показалась",registerPage.isErrorShown());

    }

}
