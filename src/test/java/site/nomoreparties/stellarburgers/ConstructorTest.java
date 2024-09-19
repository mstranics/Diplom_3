package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;

import static org.junit.Assert.assertTrue;


public class ConstructorTest extends BaseTest{




@Test
@DisplayName("Pan tab can be opened")
    public void openPans (){
    MainPage mainPage = new MainPage(driver);
    mainPage.clickSaucesButton();
    mainPage.clickFillingsButton();
    mainPage.clickPansButton();
    assertTrue(mainPage.isPansEnabled());
}
    @Test
    @DisplayName("Sauces tab can be opened")
    public void openSauces (){

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesButton();
        assertTrue(mainPage.isSaucesEnabled());
    }
    @Test
    @DisplayName("Fillings tab can be opened")
    public void openFillings (){


        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        assertTrue(mainPage.isFillingsEnabled());
    }

}
