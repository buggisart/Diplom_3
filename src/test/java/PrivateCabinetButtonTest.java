import PageObject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.Matchers.containsString;

public class PrivateCabinetButtonTest {
    WebDriver driver;
    MainPage mainPage;
    private String email = "test987@test.com";
    private String password = "test123";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        mainPage.loginWithLoginButton(email,password);
    }

    @Test
    public void privateCabinetButtonClickFromMainPageSuccess() {
            mainPage.privateCabinetButtonFromMainPageClick();
        By SAVE_BUTTON = By.xpath(".//button[text() ='Сохранить']");
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
            Assert.assertThat(driver.findElement(SAVE_BUTTON).getText(), containsString("Сохранить"));
    }

    @After
    public void tearDown() {
        driver.quit();
}
}
