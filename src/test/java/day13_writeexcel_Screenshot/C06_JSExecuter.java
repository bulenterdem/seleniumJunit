package day13_writeexcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_JSExecuter extends TestBase {

    @Test
    public void test01(){

        // amazon sayfaya gidin

        driver.get("http://www.amazon.com");

        // sell linkine JS executer kullanarak click yapin

        WebElement sellLinki= driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",sellLinki);

        jse.executeScript("alert('Bu is bu kadar')");

        ReusableMethods.bekleMethodu(5);


    }
}
