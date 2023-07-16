import org.example.common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Constants.CHROME_ARGUMENT);
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void TestValidCredentials() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("admin");
        loginPage.setPassword("manager");
        loginPage.clickLoginButton();
    }

    @Test
    public void TestIncorrectUserName() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("IncorrectUser");
        loginPage.setPassword("manager");
        loginPage.clickLoginButton();
    }

    @Test
    public void TestIncorrectPassword() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("admin");
        loginPage.setPassword("IncorrectPassword");
        loginPage.clickLoginButton();
    }


    @Test
    public void TestInvalidCredential() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("IncorrectUser");
        loginPage.setPassword("IncorrectPassword");
        loginPage.clickLoginButton();

    }

    @Test
    public void TestAccessToReportsWithoutLogin() {
        Reports reports = new Reports(driver);
        reports.open();

    }

    @Test
    public void ViewreportsDashboard() {
        Login loginPage = new Login(driver);
        Reports reports = new Reports(driver);

        loginPage.open();
        loginPage.setUsername("admin");
        loginPage.setPassword("manager");
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/user/submit_tt.do"));

        reports.clickReportsContainer();
    }
}
