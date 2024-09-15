package site.nomoreparties.stellarburgers;

import Helpers.UserClient;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.fragment.HeaderFragment;
import site.nomoreparties.stellarburgers.pageobject.page.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;
import site.nomoreparties.stellarburgers.pageobject.page.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterUserTest extends BaseTest{
    Faker faker = new Faker();
    private UserClient userClient;
    private String accessToken;
    public static String URL ="https://stellarburgers.nomoreparties.site/login";
    private String email;
    private String name;
    private String password;
    @Before
    public void setUp() {
        userClient = new UserClient();
    }
    @After
public void cleanUP() {
   ValidatableResponse loginResponse= userClient.login(email,password);
   accessToken=loginResponse.extract().path("accessToken");
    userClient.delete(accessToken);
}
@Test
@DisplayName("User can be registered with all required params")
    public void userRegistered (){
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    HeaderFragment headerFragment = new HeaderFragment(driver);
    headerFragment.clickAccountButton();
    loginPage.clickRegisterButton();
    name=faker.name().username();
    email=faker.internet().emailAddress();
    password=faker.internet().password(6,7);
    registerPage.registerNewUser(name,email,password);
    assertTrue(loginPage.isLoginFormShown());
 assertEquals("страница логина не загрузилась",URL,loginPage.getPageUrl()); // возможно избыточно, но зато точно убедимся ,что страница нужная
}


}
