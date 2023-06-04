import PageObject.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegisterTest {
    RegisterPage registerPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(registerPage.getURL());
        registerPage = new RegisterPage(driver);
    }
    @Test
    public void registerUserWithCorrectCredsSuccess() {
     registerPage.registerUser();
    }
}
