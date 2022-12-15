import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageObject extends PageObject{
    public static final String url = "https://stellarburgers.nomoreparties.site/account/profile";
    private By homeLink = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");
    private By constructorLink = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");
    private By logoutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    public ProfilePageObject(WebDriver driver) {
        super(driver, url);
    }

    public void clickHomeLink() {
        driver.findElement(homeLink).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
