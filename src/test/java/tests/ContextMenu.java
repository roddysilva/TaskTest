package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Elements;
import utilities.Urls;

public class ContextMenu {

    private WebDriver driver;

    @Test
    public void testContextMenu() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Urls.CONTEXT_MENU);
        WebElement contextMenuElement = driver.findElement(By.id(Elements.CONTEXT_MENU));
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuElement).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        driver.quit();
    }
}
