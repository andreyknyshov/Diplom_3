import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageObject extends PageObject {
    public static final String url = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By loginLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    public ForgotPasswordPageObject(WebDriver driver) {
        super(driver, url);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
