package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {

    /*..........Exercise1............

    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin

     */
    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){
        //  driver.close();
    }

    @Test
    public void test01(){

        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@ class='gLFyf']"))
                .sendKeys("The Lord of the Rings"+ Keys.ENTER);

         WebElement sonuc1= driver.findElement(By.xpath("//div[@ id='result-stats']"));
        sonuc1.getText();

        driver.findElement(By.xpath("//span[@ class=\"ExCKkf z1asCe rzyADb\"]")).click();

        driver.findElement(By.xpath("//input[@ class='gLFyf']"))
                .sendKeys("Brave Heart"+ Keys.ENTER);

        WebElement sonuc2= driver.findElement(By.xpath("//div[@ id='result-stats']"));

        sonuc2.getText();
        driver.findElement(By.xpath("//span[@ class=\"ExCKkf z1asCe rzyADb\"]")).click();

        driver.findElement(By.xpath("//input[@ class='gLFyf']"))
                .sendKeys("Harry Potter"+ Keys.ENTER);

        WebElement sonuc3= driver.findElement(By.xpath("//div[@ id='result-stats']"));

        sonuc3.getText();


    }
}
