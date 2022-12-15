import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    WebDriver driver;
    RegistrationPageObject registrationPageObject;
    LoginPageObject loginPageObject;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        registrationPageObject = new RegistrationPageObject(driver);
        loginPageObject = new LoginPageObject(driver);
    }

    @Test
    public void canLogin() {
        registrationPageObject.openPage();
        final String username = Utils.nextUsername(), email = Utils.nextEmail(), password = Utils.nextPassword();
        registrationPageObject.registerUser(username, email, password);
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
        loginPageObject.loginUser(email, password);
        Utils.waitForUrlToBe(driver, HomePageObject.url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
