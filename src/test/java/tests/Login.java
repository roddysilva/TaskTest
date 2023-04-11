package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import utilities.LoginElements;
import utilities.Urls;


public class Login {

    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeMethod
    public void configTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get(Urls.LOGIN_URL);
    }

    @Test
    public void successLoginTest() {
        loginPage.setUsername(LoginElements.USERNAME_FIELD);
        loginPage.setPassword(LoginElements.PASSWORD_FIELD);
        loginPage.clickLoginButton();
        String confirmation = loginPage.findLoginConfirmation();
        Assert.assertEquals(LoginElements.LOGIN_CONFIRMATION_TEXT.trim(), confirmation.trim());
    }

    @Test
    public void failureLoginTest() {
        loginPage.setUsername(LoginElements.USERNAME_FIELD_FAILURE);
        loginPage.setPassword(LoginElements.PASSWORD_FIELD_FAILURE);
        loginPage.clickLoginButton();
        String failure = loginPage.findLoginFailure();
        Assert.assertEquals(LoginElements.LOGIN_FAILURE_TEXT.trim(), failure.trim());
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
