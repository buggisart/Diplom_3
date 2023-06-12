import PageObject.RegisterPage;
import User.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
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

import static org.hamcrest.CoreMatchers.containsString;

public class RegisterTest {
    RegisterPage registerPage;

    private String email = "AutoQA_Java1996@gmail.com";
    private String password = "TestPassword123";

    private String name = "TestName987123";

    User user = new User(email, password, name );

    UserClient userClient = new UserClient();
    WebDriver driver;
    UserCredentials userCredentials = new UserCredentials(user.getEmail(), user.getPassword());
    String authToken;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.getURL());
    }
    @Test
    public void registerUserWithCorrectCredsSuccess() {
     registerPage.registerUser(email, password, name);
     By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
     new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
     Assert.assertThat("Должна была открыться страница с логином",
                driver.findElement(LOGIN_BUTTON).getText(), containsString("Войти"));
    }

    @Test
    public void registerUserWithIncorrectPassError() {
        registerPage.registerUser(email,"5symb", name);
        By INCORRECT_PASSWORD = By.xpath(".//p[text() = 'Некорректный пароль']");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(INCORRECT_PASSWORD));
        Assert.assertThat("Должна была открыться страница с логином",
                driver.findElement(INCORRECT_PASSWORD).getText(), containsString("Некорректный пароль"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @After
    public void loginAndDeleteUser() {
        ValidatableResponse loginResponse = userClient.login(userCredentials);
        if (loginResponse.extract().path("success").toString().equals("true")) {
            authToken = loginResponse.extract().path("accessToken").toString();
            userClient.deleteUser(authToken);
        }
    }

}
