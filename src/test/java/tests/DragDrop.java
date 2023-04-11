package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Elements;
import utilities.Urls;


public class DragDrop {

    private WebDriver driver;

    @BeforeMethod
    public void configTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Urls.DRAGNDROP);
    }

    @Test
    public void testContextMenuText() {
        WebElement columnA = driver.findElement(By.id(Elements.COLUMN_A));
        WebElement columnB = driver.findElement(By.id(Elements.COLUMN_B));
        Assert.assertEquals(columnA.getText(), "A");
        Assert.assertEquals(columnB.getText(), "B");
    }

    @Test
    public void testDragDrop() {
        WebElement columnA = driver.findElement(By.id(Elements.COLUMN_A));
        WebElement columnB = driver.findElement(By.id(Elements.COLUMN_B));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(columnA, columnB).build().perform();

        Assert.assertEquals(columnB.getText(), "B");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}