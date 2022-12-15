import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Utils {
    private static Random random = new Random();


    public static String nextUsername() {
        return String.format("user%d", random.nextInt());
    }

    public static String nextEmail() {
        return String.format("%s@yandex.ru", nextUsername());
    }

    public static String nextPassword(int maxLength) {
        return nextPassword().substring(0, maxLength);
    }

    public static String nextPassword() {
        return String.format("%016d", random.nextInt());
    }

    public static void waitForUrlToBe(WebDriver driver, String url) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe(url));
    }

    public static void registerAndLoginUser(WebDriver driver) {
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        final String username = Utils.nextUsername(), password = Utils.nextPassword(), email = Utils.nextEmail();

        registrationPageObject.openPage();
        registrationPageObject.registerUser(username, email, password);
        Utils.waitForUrlToBe(driver, LoginPageObject.url);
        loginPageObject.loginUser(email, password);
        Utils.waitForUrlToBe(driver, HomePageObject.url);
    }
}
