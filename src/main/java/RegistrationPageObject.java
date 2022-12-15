import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObject extends PageObject {
    public static final String url = "https://stellarburgers.nomoreparties.site/register";

    private By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private By passwordErrorText = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    private By registerButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By loginLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    public RegistrationPageObject(WebDriver driver) {
        super(driver, url);
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void registerUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public boolean hasInputError() {
        return driver.findElement(passwordErrorText).isDisplayed();
    }
}

