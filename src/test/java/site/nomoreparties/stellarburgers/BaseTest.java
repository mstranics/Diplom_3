package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.pageobject.page.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    Properties properties = new Properties();
    @Before
    public void setUpDriver () {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver=getDriver(properties.getProperty("BROWSER"));
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
          /*  case "firefox":
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
                return new FirefoxDriver(); */
            case "yandex":
                System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver");
           //     ChromeOptions options = new ChromeOptions();
            //    options.setBinary(properties.getProperty("ya.binary"));
                    return new ChromeDriver();
            default:
                throw new IllegalArgumentException("такой driverType не поддерживается ");
        }
}

}
