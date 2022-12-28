package day08_HandlingWindows;

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
import java.util.Set;

public class C03_WindowHandle {

    WebDriver driver;

    @Before
    public void Setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown() {

        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilksayfaHandleDegeri=driver.getWindowHandle();


        // elemental selenium linkini tiklayin

        driver.findElement(By.xpath("//a [text()='Elemental Selenium']")).click();


            // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin

        Set<String> tumWHDegerleriSeti= driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWhd: tumWHDegerleriSeti
        ) {
            if (!eachWhd.equals(ilksayfaHandleDegeri)){
                ikinciSayfaWHD=eachWhd;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        String actualikincisayfaYazi=driver.findElement(By.tagName("h1")).getText();
        String expectedeikincisayfaYazi="Elemental Selenium";
        Assert.assertEquals(expectedeikincisayfaYazi,actualikincisayfaYazi);

        Thread.sleep(3000);

        // ilk sayfaya geri donup sayfadaki yazinin

        driver.switchTo().window(ilksayfaHandleDegeri);



        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

        String expectedilkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualIlkSayfaYazi= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedilkSayfaYazi,actualIlkSayfaYazi);

        Thread.sleep(3000);











    }

}
