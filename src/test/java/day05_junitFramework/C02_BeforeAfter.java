package day05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    // 3 farkli test methodu olusturun
    // her bir methodun basinda driver'i olusturup
    // 1. methodda amazon.com
    //2. methodda wiswquarter.com
    //3. methodda youtube.com a gidip title yazdirin ve methoddan sonra driveri kapatin
    WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setUp Methodu Calisti");
    }
    @After
    public void tearDown(){
        System.out.println("teardown methodu calisti");
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {

        driver.get("http://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {

        driver.get("http://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }

    @Test
    public void test03() throws InterruptedException {

        driver.get("http://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
}
