package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class S06_JunitActionSorusu extends TestBase {

    @Test
    public void Test01(){

        driver.get("http://webdriveruniversity.com/Actions");

        //"Hover over Me First" kutusunun ustune gelin

        WebElement MeFirstElementi= driver.findElement(By.xpath("//button[ text()='Hover Over Me First!']"));

        Actions actions=new Actions(driver);

        actions.moveToElement(MeFirstElementi).perform();

        //3. "Link 1" e tiklayin

        driver.findElement(By.xpath("(//a [@ class='list-alert'])[1]")).click();


        //4. Popup mesajini yazdirin


        String actualalertYazisi=driver.switchTo().alert().getText();

        System.out.println(actualalertYazisi);

        //5. Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun

        WebElement ClickHoldElemeneti= driver.findElement(By.xpath("//*[@id='click-box']"));

        actions.clickAndHold(ClickHoldElemeneti).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(ClickHoldElemeneti.getText());


        //8. "Double click me" butonunu cift tiklayin

        WebElement doubleClickElementi= driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));

        actions.doubleClick(doubleClickElementi).perform();


    }
}
