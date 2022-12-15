import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLoginTest {
    private WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void canOpenLoginFromLoginButtonOnHomePage() {
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickLoginButton();
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
    }

    @Test
    public void canOpenLoginFromCabinetLinkOnHomePage() {
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.openPage();
        homePageObject.clickCabinetLink();
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
    }

    @Test
    public void canOpenLoginFromLoginLinkOnRegistrationPage() {
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        registrationPageObject.openPage();
        registrationPageObject.clickLoginLink();
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
    }

    @Test
    public void canOpenLoginFromLoginLinkOnForgotPasswordPage() {
        ForgotPasswordPageObject forgotPasswordPageObject = new ForgotPasswordPageObject(driver);
        forgotPasswordPageObject.openPage();
        forgotPasswordPageObject.clickLoginLink();
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
