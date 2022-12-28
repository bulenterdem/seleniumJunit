package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class S02_HandleDropDown {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElementi= driver.findElement(By.xpath("//select[@ id='dropdown']"));

        Select select=new Select(dropdownElementi);

        select.selectByIndex(1);

        System.out.println(dropdownElementi.getText());


        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElementi1= driver.findElement(By.xpath("//select[@ id='dropdown']"));

        Select select=new Select(dropdownElementi1);

        select.selectByValue("2");

        System.out.println(dropdownElementi1.getText());


        Thread.sleep(2000);
    }


    @Test
    public void test03 () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElementi2= driver.findElement(By.xpath("//select[@ id='dropdown']"));

        Select select=new Select(dropdownElementi2);

        select.selectByVisibleText("Option 1");

        System.out.println(dropdownElementi2.getText());


        Thread.sleep(2000);
    }

    @Test
    public void test04 () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElementi3= driver.findElement(By.xpath("//select[@ id='dropdown']"));

        Select select=new Select(dropdownElementi3);

        List<WebElement> optionsWebElementListesi =select.getOptions();

        System.out.println(dropdownElementi3);

        int actualOptionSayisi = optionsWebElementListesi.size();
        int expectedOptionSayisi=4;

      Assert.assertEquals(expectedOptionSayisi,expectedOptionSayisi);
        Thread.sleep(2000);
    }



}
