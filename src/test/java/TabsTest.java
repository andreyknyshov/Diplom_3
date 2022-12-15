import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabsTest {
    WebDriver driver;
    HomePageObject homePageObject;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        homePageObject = new HomePageObject(driver);
    }

    @Test
    public void canSelectTabs() throws Exception {
        homePageObject.openPage();
        for(HomePageObject.Tab tab : HomePageObject.Tab.values()) {
            homePageObject.clickTabButton(tab);
            new WebDriverWait(driver, 10).until((d) -> {
                try {
                    return homePageObject.isTabDisplayed(tab);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
