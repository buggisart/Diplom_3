import PageObject.MainPage;
import PageObject.RecoveryPasswordPage;
import PageObject.RegisterPage;
import User.User;
import User.UserClient;
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

import static org.hamcrest.Matchers.containsString;

public class LoginTest {

    WebDriver driver;
    MainPage mainPage;
    UserClient userClient;
    private String email = "AutoQA_Java1996@gmail.com";

    private String password = "TestPassword123";
    private String name = "randomName";
    private String authToken;
    User user = new User(email,password, name);
    RegisterPage registerPage;
    RecoveryPasswordPage recoveryPasswordPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        registerPage = new RegisterPage(driver);
        mainPage = new MainPage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);
        userClient = new UserClient();
        ValidatableResponse createUserResponse = userClient.create(user);
        authToken = createUserResponse.extract().path("accessToken").toString();
    }

    @Test
    public void loginFromMainPageWithLoginButtonSuccess() {
        driver.get(mainPage.getUrl());
        mainPage.loginWithLoginButton(email, password);
        By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON));
        Assert.assertThat(driver.findElement(CREATE_ORDER_BUTTON).getText(), containsString("Оформить заказ"));
    }

    @Test
    public void loginFromPrivateCabinetButtonSuccess() {
        driver.get(mainPage.getUrl());
        mainPage.loginWithPrivateCabinetButton(email, password);
        By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON));
        Assert.assertThat(driver.findElement(CREATE_ORDER_BUTTON).getText(), containsString("Оформить заказ"));
    }

    @Test
    public void loginWithLoginButtonFromRegisterPageSuccess() {
        driver.get(registerPage.getURL());
        mainPage.loginWithLoginButtonFromRegisterPage(email, password);
        By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON));
        Assert.assertThat(driver.findElement(CREATE_ORDER_BUTTON).getText(), containsString("Оформить заказ"));
    }

    @Test
    public void loginWithLoginButtonFromRecoveryPasswordPageSuccess() {
        driver.get(recoveryPasswordPage.getUrl());
        mainPage.loginWithLoginButtonFromRecoveryPasswordPage(email, password);
        By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON));
        Assert.assertThat(driver.findElement(CREATE_ORDER_BUTTON).getText(), containsString("Оформить заказ"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @After
    public void deleteUser() {
        userClient.deleteUser(authToken);
    }
}
