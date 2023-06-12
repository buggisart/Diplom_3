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


public class ConstructorTransitionsTest {
    WebDriver driver;
    MainPage mainPage;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
    }

    @Test
    public void clickOnSaucesConstructorSuccess() {
        mainPage.constructorClickOnSauces();
        By BUNS_NO_SELECTED = By.xpath(".//section[1]/div[1]/div[1][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
        By FILLINGS_NO_SELECTED = By.xpath(".//section[1]/div[1]/div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
        Assert.assertTrue(driver.findElement(BUNS_NO_SELECTED).isDisplayed());
        Assert.assertTrue(driver.findElement(FILLINGS_NO_SELECTED).isDisplayed());

    }
    @Test
    public void clickOnFillingConstructorSuccess() {
        mainPage.constructorClickOnFillings();
        By BUNS_NO_SELECTED = By.xpath(".//section[1]/div[1]/div[1][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
        By SAUCES_NO_SELECTED = By.xpath(".//section[1]/div[1]/div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
        Assert.assertTrue(driver.findElement(BUNS_NO_SELECTED).isDisplayed());
        Assert.assertTrue(driver.findElement(SAUCES_NO_SELECTED).isDisplayed());
    }
    @Test
    public void clickOnBunsConstructorSuccess() {
        mainPage.constructorClickOnSauces();
        mainPage.constructorClickOnBuns();
        By FILLINGS_NO_SELECTED = By.xpath(".//section[1]/div[1]/div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
        By SAUCES_NO_SELECTED = By.xpath(".//section[1]/div[1]/div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
        Assert.assertTrue(driver.findElement(FILLINGS_NO_SELECTED).isDisplayed());
        Assert.assertTrue(driver.findElement(SAUCES_NO_SELECTED).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
