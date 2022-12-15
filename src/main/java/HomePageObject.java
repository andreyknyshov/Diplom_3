import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends PageObject {
    public final static String url = "https://stellarburgers.nomoreparties.site/";
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    private By cabinetLink = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
    private By bunTabButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span");
    private By sauceTabButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    private By fillingTabButton = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");
    private By bunTabTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");
    private By sauceTabTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]");
    private By fillingTabTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");

    public HomePageObject(WebDriver driver) {
        super(driver, url);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickCabinetLink() {
        driver.findElement(cabinetLink).click();
    }

    public void clickTabButton(Tab tab) throws Exception {
        By tabButton;
        switch (tab) {
            case BUN:
                tabButton = bunTabButton;
                break;
            case SAUCE:
                tabButton = sauceTabButton;
                break;
            case FILLING:
                tabButton = fillingTabButton;
                break;
            default:
                throw new Exception("Undefined tab type");
        }

        WebElement tabButtonElement = driver.findElement(tabButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(tabButtonElement).click().build().perform();
    }

    public boolean isTabDisplayed(Tab tab) throws Exception {
        By tabTitle;
        switch (tab) {
            case BUN:
                tabTitle = bunTabTitle;
                break;
            case SAUCE:
                tabTitle = sauceTabTitle;
                break;
            case FILLING:
                tabTitle = fillingTabTitle;
                break;
            default:
                throw new Exception("Undefined tab type");
        }

        return driver.findElement(tabTitle).isDisplayed();
    }

    public enum Tab {
        BUN, SAUCE, FILLING
    }
}
