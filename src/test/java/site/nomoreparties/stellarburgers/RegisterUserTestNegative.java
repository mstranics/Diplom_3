package site.nomoreparties.stellarburgers;

import com.github.javafaker.Faker;
import helpers.User;
import helpers.UserClient;
import helpers.UserHelper;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.fragment.HeaderFragment;
import site.nomoreparties.stellarburgers.pageobject.page.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterUserTestNegative extends BaseTest {
    Faker faker = new Faker();

    private User user;
    private UserClient userClient;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = UserHelper.addUser();
    }

    @Test
    @DisplayName("User can't be registered with password <6")
    public void userNotRegisteredPassValidation() {

        LoginPage loginPage = new LoginPage(driver);
        HeaderFragment headerFragment = new HeaderFragment(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        headerFragment.clickAccountButton();
        loginPage.clickRegisterButton();
        user.setPassword(faker.internet().password(4, 5));
        registerPage.registerNewUser(user);
        assertTrue("нужная ошибка не показалась", registerPage.isErrorShown());

    }

}
