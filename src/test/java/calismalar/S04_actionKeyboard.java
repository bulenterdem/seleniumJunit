package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class S04_actionKeyboard extends TestBase {

    @Test
      public void test01 (){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin

        WebElement ifrmaElement = driver.findElement(By.xpath("//iframe[@height='315']"));
        driver.switchTo().frame(ifrmaElement);

        Actions actions=new Actions(driver);

        //4- videoyu izlemek icin Play tusuna basin

        WebElement PlayTusu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));

        actions.moveToElement(PlayTusu)
                        .perform();
        PlayTusu.click();

        ReusableMethods.bekleMethodu(5);



        //5- videoyu calistirdiginizi test edin

        Assert.assertTrue(PlayTusu.isEnabled());


    }
}
