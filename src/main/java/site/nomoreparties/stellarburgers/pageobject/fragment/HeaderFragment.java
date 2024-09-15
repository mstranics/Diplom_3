package site.nomoreparties.stellarburgers.pageobject.fragment;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.pageobject.page.BasePage;

import java.time.Duration;
import java.util.List;

public class HeaderFragment extends BasePage {
    public HeaderFragment(WebDriver driver) {
        super(driver);
    }
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");   //кнопка личный кабинет
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");//кнопка конструктор
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
   @Step("Click account button")
    public void clickAccountButton() {
       List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
       new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(overlays));
       driver.findElement(accountButton).click();

    }
    @Step("Click constructor button")
    public void clickConstructorButton ()  {
     List<WebElement> overlays = driver.findElements(By.className("Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(constructorButton)).click();

    /*   Actions action = new Actions(driver);
        action.click(driver.findElement(constructorButton)).perform(); */

    }
    @Step("Click logo ")
    public  void clickLogo()   {
        List<WebElement> overlays = driver.findElements(By.className("Modal_modal_overlay__x2ZCr"));
       new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(logo)).click();
   /*  Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(logo)).click().perform(); */
 }
}
