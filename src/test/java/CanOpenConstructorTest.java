import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CanOpenConstructorTest {
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
    public void canOpenConstructorFromConstructorLinkOnProfilePage() {
        Utils.registerAndLoginUser(driver);

        // Cannot imperatively open profile page url
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickCabinetLink();
        Utils.waitForUrlToBe(driver, ProfilePageObject.url);

        profilePageObject.clickConstructorLink();
        Utils.waitForUrlToBe(driver, HomePageObject.url);
    }

    @Test
    public void canOpenConstructorFromHomeLinkOnProfilePage() {
        Utils.registerAndLoginUser(driver);

        // Cannot imperatively open profile page url
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickCabinetLink();
        Utils.waitForUrlToBe(driver, ProfilePageObject.url);

        profilePageObject.clickHomeLink();
        Utils.waitForUrlToBe(driver, HomePageObject.url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
