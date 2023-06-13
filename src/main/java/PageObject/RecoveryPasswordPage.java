package PageObject;

import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }
    WebDriver driver;


}
