package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {

    /*
        Selenium 4 ile windows konusunda yeni bir oellik geldi
        istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
        bu durumda driverimiz da otomatik olarak yeni sayfya gecmis olur

        testin ilerleyen asmalarinda yeniden eski sayfaya donus gorevi varsa
        o sayfada iken o sayfanin window handle degeri alinip kaydedilir ve osayfaya gecmek istendiginde

        drive.swictTo().window(isteneSayfaninWindowHandledegeri)

             */
    WebDriver driver;
    @Before
    public void Setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){

        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        // testin ilerleyen asamalarinda yeniden amazon saydfasina donmek gerekiyorsa
        // amazon sayfasindayken bu windowun window handle degerini alip kaydetmeliyiz

        String ilksayfaHandleDegeri= driver.getWindowHandle();

        // yeni bir tab da wiswqurter.com'a gidin ve gittigmizi test edin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedkelime="wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedkelime));
        Thread.sleep(3000);


        // wiswquarter testini yaptiktan sonra yeniden amazon acik oldugu tab'a gecin
         //  ve amazonun acik oldugunu test edin


        driver.switchTo().window(ilksayfaHandleDegeri);

        String ilkactualUrl= driver.getCurrentUrl();
        String ilkexpectedKelime="amazon";

        Assert.assertTrue(ilkactualUrl.contains(ilkexpectedKelime));
        Thread.sleep(3000);


    }
}
