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

import java.sql.DriverManager;
import java.time.Duration;

public class T02_tekrarSorusu2 {

    //Yeni bir class olusturun (TekrarTesti)
    //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
    //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
    //doğru URL'yi yazdırın.
    //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    //5. Youtube sayfasina geri donun
    //6. Sayfayi yenileyin
    //7. Amazon sayfasina donun
    //8. Sayfayi tamsayfa yapin
    //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
    //Yoksa doğru başlığı(Actual Title) yazdırın.
    //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
    //doğru URL'yi yazdırın
    //11.Sayfayi kapatin

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){

        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("http://www.youtube.com");

     String  youTubeUrl=driver.getCurrentUrl();
      String expect="youtube";

      Assert.assertTrue(youTubeUrl.contains(expect));

      Thread.sleep(3000);

        System.out.println(youTubeUrl);



    }


    @Test
    public void test02() throws InterruptedException {

        driver.get("http://www.amazon.com");

        String amazonUrl=driver.getCurrentUrl();

        String expectAmazon="amazon";

        System.out.println(amazonUrl);



        Thread.sleep(3000);

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.manage().window().fullscreen();



        Assert.assertTrue(amazonUrl.contains(expectAmazon));


    }


}
