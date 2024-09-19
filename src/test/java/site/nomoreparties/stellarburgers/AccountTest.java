package site.nomoreparties.stellarburgers;

import helpers.User;
import helpers.UserClient;
import com.github.javafaker.Faker;
import helpers.UserCreds;
import helpers.UserHelper;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import site.nomoreparties.stellarburgers.pageobject.fragment.HeaderFragment;
import site.nomoreparties.stellarburgers.pageobject.page.AccountPage;
import site.nomoreparties.stellarburgers.pageobject.page.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AccountTest extends BaseTest {
    Faker faker = new Faker();
    private UserClient userClient;
    private User user;
    private String accessToken;
    private String refreshToken;


    @Before
    public void setUp() {
        userClient = new UserClient();
        user = UserHelper.addUser();
        ValidatableResponse createResponse = userClient.create(user);
        assertEquals(200, createResponse.extract().statusCode());
        accessToken = createResponse.extract().path("accessToken");
        refreshToken = createResponse.extract().path("refreshToken");

    }

    @After
    public void cleanUP() {
        userClient.delete(accessToken);
    }

    @Test
    @DisplayName("Profile can be opened ")
    public void openAccount() {

        HeaderFragment headerFragment = new HeaderFragment(driver);
        AccountPage accountPage = new AccountPage(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('accessToken','%s');", accessToken)));

        headerFragment.clickAccountButton();
        assertTrue(accountPage.isProfileShown());

    }

    @Test
    @DisplayName("Profile can be quited ")
    public void quitAccount() {

        HeaderFragment headerFragment = new HeaderFragment(driver);
        AccountPage accountPage = new AccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('accessToken','%s');", accessToken)));
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('refreshToken','%s');", refreshToken)));
        headerFragment.clickAccountButton();
        accountPage.clickExitButton();
        assertTrue(loginPage.isLoginFormShown());


    }

    @Test
    @DisplayName("Constructor can be opened from account via constructor button ")
    public void constructorIsOpenedFromAccount() {

        HeaderFragment headerFragment = new HeaderFragment(driver);
        MainPage mainPage = new MainPage(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('accessToken','%s');", accessToken)));
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('refreshToken','%s');", refreshToken)));
        headerFragment.clickAccountButton();
        headerFragment.clickConstructorButton();
        assertTrue(mainPage.isCreateOrderShown());

    }

    @Test
    @DisplayName("Constructor can be opened from account via logo ")
    public void constructorIsOpenedFromAccountViaLogo() {

        HeaderFragment headerFragment = new HeaderFragment(driver);
        MainPage mainPage = new MainPage(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('accessToken','%s');", accessToken)));
        jsExecutor.executeScript((String.format(
                "window.localStorage.setItem('refreshToken','%s');", refreshToken)));
        headerFragment.clickAccountButton();
        headerFragment.clickLogo();
        assertTrue(mainPage.isCreateOrderShown());
    }
}
