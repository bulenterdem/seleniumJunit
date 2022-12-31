package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class s03_IFrameSoru extends TestBase {


    @Test
            public void test01() throws InterruptedException {


         //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        String ilkTabHandle = driver.getWindowHandle();

        //2) sayfadaki iframe sayısını bulunuz.
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Sayfadaki iframe sayısı: " + iframeCount);

        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ifrmaElement = driver.findElement(By.xpath("//iframe[@height='315']"));
        driver.switchTo().frame(ifrmaElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke tıklayın
        WebElement ifrmae2Element = driver.findElement(By.xpath("//iframe[@name='a077aa5e']"));
        driver.switchTo().frame(ifrmae2Element);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

        Set<String>tumHandleler=driver.getWindowHandles();
        String ikinciHandle="";

        for (String eachHandle : tumHandleler
        ) {
            if (!eachHandle.equals(ilkTabHandle)){
                ikinciHandle=eachHandle;
            }
        }
        driver.switchTo().window(ikinciHandle);
        System.out.println(ikinciHandle);
        WebElement drobdown=   driver.findElement(By.xpath("//span[text()='Live Project']"));
        drobdown.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[text()='Live Selenium Project'])[1]")).click();



        //(https://www.guru99.com/live-selenium-project.html) tıklayınız





    }



}
