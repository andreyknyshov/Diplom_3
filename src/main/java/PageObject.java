import org.openqa.selenium.WebDriver;

public class PageObject {
    private final String url;
    protected WebDriver driver;

    public PageObject(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void openPage() {
        driver.get(url);
    }
}
