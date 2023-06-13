package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private String url = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public String getUrl() {
        return url;
    }

    private static final By LOGIN_BUTTON_MAIN_PAGE = By.xpath(".//button[text()='Войти в аккаунт']");

    private static final By PRIVATE_CABINET_BUTTON_MAIN_PAGE = By.xpath(".//a[@href='/account']");

    private static final By EMAIL_FIELD = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type = 'text']");
    private static final By PASSWORD_FIELD = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type = 'password']");
    private static final By LOGIN_BUTTON_LOGIN_PAGE = By.xpath(".//button[text() = 'Войти']");
    private static final By LOGIN_BUTTON_REGISTER_PAGE = By.xpath(".//a[text() = 'Войти']");

    private static final By LOGIN_BUTTON_RECOVERY_PASSWORD_PAGE = By.xpath(".//a[text() ='Войти']");
    private static final By LOGO_BUTTON = By.xpath(".//a[@href ='/']");
    private static final By LOGOUT_BUTTON = By.xpath(".//button[text() ='Выход']");
    private static final By SAUCES = By.xpath(".//span[text() ='Соусы']");
    private static final By FILLINGS = By.xpath(".//span[text() ='Начинки']");
    private static final By BUNS = By.xpath(".//span[text() ='Булки']");



    public void typeEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void typePassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }


public void loginWithLoginButton(String email, String password) {
    driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
    typeEmail(email);
    typePassword(password);
    driver.findElement(LOGIN_BUTTON_LOGIN_PAGE).click();
    }

    public void loginWithPrivateCabinetButton(String email, String password) {
        driver.findElement(PRIVATE_CABINET_BUTTON_MAIN_PAGE).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
        typeEmail(email);
        typePassword(password);
        driver.findElement(LOGIN_BUTTON_LOGIN_PAGE).click();
    }

    public void loginWithLoginButtonFromRegisterPage(String email, String password) {
        driver.findElement(LOGIN_BUTTON_REGISTER_PAGE).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
        typeEmail(email);
        typePassword(password);
        driver.findElement(LOGIN_BUTTON_LOGIN_PAGE).click();
    }

    public void loginWithLoginButtonFromRecoveryPasswordPage(String email, String password) {
        driver.findElement(LOGIN_BUTTON_RECOVERY_PASSWORD_PAGE).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
        typeEmail(email);
        typePassword(password);
        driver.findElement(LOGIN_BUTTON_LOGIN_PAGE).click();
    }
    public void privateCabinetButtonFromMainPageClick() {
        driver.findElement(PRIVATE_CABINET_BUTTON_MAIN_PAGE).click();
    }

    public void logoButtonClickFromPrivateCabinet() {
        driver.findElement(LOGO_BUTTON).click();
    }

    public void logoutButtonClickFromPrivateCabinet() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void constructorClickOnBuns() {
        driver.findElement(BUNS).click();
    }
    public void constructorClickOnSauces() {
        driver.findElement(SAUCES).click();
    }
    public void constructorClickOnFillings() {
        driver.findElement(FILLINGS).click();
    }
}



