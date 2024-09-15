package site.nomoreparties.stellarburgers;

import Helpers.UserClient;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.fragment.HeaderFragment;
import site.nomoreparties.stellarburgers.pageobject.page.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pageobject.page.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;
import site.nomoreparties.stellarburgers.pageobject.page.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginUserTest extends BaseTest{
    Faker faker = new Faker();
    private UserClient userClient;
    private String accessToken;

    private String email=faker.internet().emailAddress();
    private String name=faker.name().username();;
    private String password=faker.internet().password(6,7);
    @Before
    public void setUp() {
        userClient = new UserClient();
        ValidatableResponse createResponse =userClient.create(name,email,password);
        assertEquals(200,createResponse.extract().statusCode());
        accessToken=createResponse.extract().path("accessToken");
    }

    @After
public void cleanUP() {
    userClient.delete(accessToken);
}
@Test
@DisplayName("User can be logged via account button from header")
    public void loginFromMainPageAccountButton (){
    MainPage mainPage = new MainPage(driver);
    HeaderFragment headerFragment = new HeaderFragment(driver);
    LoginPage loginPage = new LoginPage(driver);
    headerFragment.clickAccountButton();
    loginPage.loginWithUser(email,password);
    assertTrue(mainPage.isCreateOrderShown());
}
    @Test
    @DisplayName("User can be logged via login to account button from main page")
    public void loginFromMainPageLoginToAccountButton (){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLoginToAccountButton();
        loginPage.loginWithUser(email,password);
        assertTrue(mainPage.isCreateOrderShown());
    }

    @Test
    @DisplayName("User can be logged via login from register page")
    public void loginFromRegisterPageLoginButton (){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HeaderFragment headerFragment = new HeaderFragment(driver);
        RegisterPage registerPage=new RegisterPage(driver);
        headerFragment.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.clickLoginButton();
        loginPage.loginWithUser(email,password);
        assertTrue(mainPage.isCreateOrderShown());
    }

    @Test
    @DisplayName("User can be logged via login from forgot password page")
    public void userFromForgotPasswordPageLoginButton (){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HeaderFragment headerFragment = new HeaderFragment(driver);
        ForgotPasswordPage forgotPasswordPage= new ForgotPasswordPage(driver);
        headerFragment.clickAccountButton();
        loginPage.clickRestorePassButton();
        forgotPasswordPage.clickLoginButton();
        loginPage.loginWithUser(email,password);
        assertTrue(mainPage.isCreateOrderShown());
    }


}