import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends PageObject{
    public final static String url = "https://stellarburgers.nomoreparties.site/login";
    private By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By registrationLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");

    public LoginPageObject(WebDriver driver) {
        super(driver, url);
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void loginUser(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
