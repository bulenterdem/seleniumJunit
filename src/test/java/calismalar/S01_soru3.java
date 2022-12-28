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

public class S01_soru3 {

    WebDriver driver;

    @Before
    public void SetUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){

        driver.close();
    }


    @Test
    public void test01(){

        driver.get("http://automationexercise.com");

        String expectUrl="https://automationexercise.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectUrl,actualUrl);

        driver.findElement(By.partialLinkText("Signup")).click();

        driver.findElement(By.xpath("(//input [@ name='email'])[1]")).sendKeys("bulenterdem@gmail.com");
        driver.findElement(By.xpath("(//input [@ name='password'])[1]")).sendKeys("2222");

        driver.findElement(By.xpath("(//button [@ class='btn btn-default'])[1]")).click();

       WebElement loginEkrani = driver.findElement(By.xpath("//*[ text()='Your email or password is incorrect!']"));

       String expectedLoginEkrani="Your email or password is incorrect!";

       String actualLoginEkrani=loginEkrani.getText();

       Assert.assertEquals(actualLoginEkrani,expectedLoginEkrani);


    }



}
