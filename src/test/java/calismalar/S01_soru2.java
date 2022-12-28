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

public class S01_soru2 {

    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");

    }
    @After
    public void tearDown(){

        driver.close();
    }
    @Test
    public void test01(){

        String actualURL= driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/";

        Assert.assertEquals(expectedUrl,actualURL);
        driver.findElement(By.partialLinkText("Signup")).click();

        WebElement ekranGoruntu =driver.findElement(By.xpath("//h2[ 'Login to your account']"));

        Assert.assertTrue(ekranGoruntu.isDisplayed());

        driver.findElement(By.xpath("(//input [@ name='email'])[1]")).sendKeys("bulenterdem111@gmail.com");
        driver.findElement(By.xpath("(//input [@ name='password'])[1]")).sendKeys("1234");

        driver.findElement(By.xpath("(//button [@ class='btn btn-default'])[1]")).click();

        WebElement Logout=driver.findElement(By.xpath("(//a['/logout'])[5]"));

        Assert.assertTrue(Logout.isDisplayed());

        driver.findElement(By.xpath("(//a['delete_account'])[6]")).click();

        driver.findElement(By.xpath("//a[ @ class='btn btn-primary']")).click();


    }





}
