package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FIELD_NAME = By.xpath(".//label[@placeholder = 'Имя']");
    private static final By FIELD_EMAIL = By.xpath(".//label[@placeholder = 'Email']");
    private static final By FIELD_PASSWORD = By.xpath(".//label[@placeholder = 'Пароль']");

    private static final By REGISTER_BUTTON = By.xpath(".//button[@text = 'Зарегистрироваться'");

    private String URL = "https://stellarburgers.nomoreparties.site/register";


    public String getURL() {
        return URL;
    }

    public void registerUser() {
            driver.findElement(FIELD_NAME).click();
            driver.findElement(FIELD_NAME).sendKeys("TestName");
        driver.findElement(FIELD_PASSWORD).click();
        driver.findElement(FIELD_PASSWORD).sendKeys("TestPaassword");
        driver.findElement(FIELD_EMAIL).click();
        driver.findElement(FIELD_EMAIL).sendKeys("test@gmail.com");
        driver.findElement(REGISTER_BUTTON).click();
    }
}
