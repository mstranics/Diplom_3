package site.nomoreparties.stellarburgers.pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage extends BasePage {

    private  final By profileButton = By.xpath(".//a[text()='Профиль']");
    private  final By exitButton = By.xpath(".//button[text()='Выход']");
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click exit button")
    public  void clickExitButton()  {
        List<WebElement> overlays = driver.findElements(By.className("Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver,5).until(ExpectedConditions.invisibilityOfAllElements(overlays)); //на этой странице так не работает пришлось втыкать слип
       // Thread.sleep(1000);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(exitButton)).click();

      /*  Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(exitButton)).click().perform(); */

    }

    @Step("Check that profile is shown")
    public boolean isProfileShown (){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(profileButton));
     return    driver.findElement(profileButton).isDisplayed();

    }

}
