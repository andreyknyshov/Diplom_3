import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CanLogoutTest {
    WebDriver driver;
    ProfilePageObject profilePageObject;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        profilePageObject = new ProfilePageObject(driver);
    }

    @Test
    public void canLogout() {
        Utils.registerAndLoginUser(driver);
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickCabinetLink();
        Utils.waitForUrlToBe(driver, ProfilePageObject.url);

        profilePageObject.clickLogoutButton();
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
