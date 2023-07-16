import org.example.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.name("pwd");
    private By loginButton = By.id("loginButton");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(Constants.WEB_URL);
        driver.manage().window().maximize();
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
