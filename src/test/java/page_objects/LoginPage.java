package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LoginElements;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.id(LoginElements.USERNAME_ID);
    private By passwordInput = By.id(LoginElements.PASSWORD_ID);
    private By loginButton = By.xpath(LoginElements.LOGIN_BUTTON);
    private By loginConfirmation = By.xpath(LoginElements.LOGIN_CONFIRMATION);
    private By loginFailure = By.xpath(LoginElements.LOGIN_FAILURE);


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.sendKeys(username);
    }


    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.sendKeys(password);
    }


    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public String findLoginConfirmation() {
        WebElement loginConfirmationElement = driver.findElement(loginConfirmation);
        String confirmation = loginConfirmationElement.getText();
        return confirmation;
    }

    public String findLoginFailure() {
        WebElement loginFailureElement = driver.findElement(loginFailure);
        String failure = loginFailureElement.getText();
        return failure;
    }

}
