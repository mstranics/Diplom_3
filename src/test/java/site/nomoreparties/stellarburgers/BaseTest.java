package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUpDriver () {
driver=getDriver("yandex");
driver.get(MainPage.URL);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @After
    //закрываем браузер
    public void tearDown() {
        driver.quit();
    }
private WebDriver getDriver (String driverType) {
        switch (driverType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
                return new FirefoxDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("такой driverType не поддерживается ");
        }
}

}
