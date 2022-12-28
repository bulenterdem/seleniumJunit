package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T01_tekrarSorusu {

    WebDriver driver;
    @Before
    public void Setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void Teardown(){

        driver.close();
    }

    @Test
    public void test01(){

        driver.get("https://www.amazon.com/");

        driver.navigate().refresh();

        String title= driver.getTitle();

        String expecttitle="spend less";

        // Assert.assertTrue(title.contains(expecttitle));

        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();

        driver.findElement(By.xpath("(//div[ @class=\"bxc-grid__image   bxc-grid__image--light\"])[3]")).click();

        driver.findElement(By.xpath("(//a[@class='nav-a'])[2]")).click();

        driver.findElement(By.xpath("(//div[@ class='a-section a-spacing-mini _cDEzb_noop_3Xbw5'])[1]")).click();

        driver.findElement(By.xpath("(//button [@ class='a-button-text'])[21]")).click();

        WebElement urunucretiekrani=driver.findElement(By.xpath("//span[@ class=\"a-color-price a-text-bold\"]"));

        String actualucretekrani=urunucretiekrani.getText();

        String expectucret="$25.00";

        Assert.assertEquals(actualucretekrani,expectucret);








    }
}
