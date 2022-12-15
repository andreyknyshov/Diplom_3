import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPageObject registrationPage;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPageObject(driver);
        registrationPage.openPage();
    }

    @Test
    public void canRegisterUser() {
        registrationPage.registerUser(Utils.nextUsername(), Utils.nextEmail(), Utils.nextPassword());
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
    }

    @Test
    public void cannotRegisterUserWithShortPassword() {
        registrationPage.registerUser(Utils.nextUsername(), Utils.nextEmail(), Utils.nextPassword(4));
        new WebDriverWait(driver, 10).until((WebDriver wd) -> registrationPage.hasInputError());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
