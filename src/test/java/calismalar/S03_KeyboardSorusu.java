package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class S03_KeyboardSorusu extends TestBase {


    @Test
    public void Test01(){


        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin

        WebElement HoverOverMeElementi=driver.findElement(By.xpath("(//button[ @class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);

        actions.moveToElement(HoverOverMeElementi).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();


        //4- Popup mesajini yazdirin

        String expectedalertYazisi="Well done you clicked on the link!";
        String actualalertYazisi=driver.switchTo().alert().getText();

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun

        WebElement clikcBoxKutusu= driver.findElement(By.xpath("//div[@ id='click-box']"));
        actions.clickAndHold(clikcBoxKutusu).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String expectedClickHoldYazisi="Well done! keep holding that click now....";
        String actualClickHoldYazisi=clikcBoxKutusu.getText();

        //8- “Double click me" butonunu cift tiklayin

        WebElement DoubleClickElementi= driver.findElement(By.tagName("h2"));
        actions.doubleClick(DoubleClickElementi).perform();

        ReusableMethods.bekleMethodu(3);
    }
}
