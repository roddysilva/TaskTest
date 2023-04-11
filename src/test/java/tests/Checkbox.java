package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import utilities.Elements;
import utilities.Urls;

public class Checkbox {

    private WebDriver driver;

    @Test
    public void testCheckbox() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Urls.CHECKBOX_URL);
        WebElement checkbox1 = driver.findElement(By.xpath(Elements.CHECKBOX_1));
        WebElement checkbox2 = driver.findElement(By.xpath(Elements.CHECKBOX_2));

        if(!checkbox1.isSelected()) {
            checkbox1.click();
        }

        if (checkbox2.isSelected()) {
            checkbox2.click();
        }


        driver.quit();
    }
}