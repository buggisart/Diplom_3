package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegisterPage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FIELD_NAME = By.xpath(".//fieldset[1]/div/div/input[@class = 'text input__textfield text_type_main-default']");
    private static final By FIELD_EMAIL = By.xpath(".//fieldset[2]/div/div/input[@class = 'text input__textfield text_type_main-default']");
    private static final By FIELD_PASSWORD = By.xpath(".//fieldset[3]/div/div/input[@class = 'text input__textfield text_type_main-default']");
    private static final By REGISTER_BUTTON = By.xpath(".//button[text() = 'Зарегистрироваться']");
    

    private String url = "https://stellarburgers.nomoreparties.site/register";


    public String getURL() {
        return url;
    }

    public void typeEmail(String email) {
        driver.findElement(FIELD_EMAIL).sendKeys(email);

    }
    public void typeName(String name) {
        driver.findElement(FIELD_NAME).sendKeys(name);

    }
    public void typePassword(String password) {
        driver.findElement(FIELD_PASSWORD).sendKeys(password);

    }
    public void registerUser(String email, String password, String name) {
        typeEmail(email);
        typePassword(password);
        typeName(name);
        driver.findElement(REGISTER_BUTTON).click();
    }

}
