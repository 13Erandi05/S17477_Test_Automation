import org.example.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reports {
    private WebDriver driver;
    private By reportsContainer = By.id("container_reports");

    public Reports(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(Constants.WEB_URL);
        driver.manage().window().maximize();
    }

    public void clickReportsContainer() {
        driver.findElement(reportsContainer).click();
    }
}
