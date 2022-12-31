package day09_Actions;

import day08_HandlingWindows.TestBaselIlkTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    @Test
    public void Test01(){



        //        2- https://www.amazon.com sayfasina gidelim

        driver.get("https://www.amazon.com ");

        //        3- Arama kutusuna actions method’larine kullanarak
        //        Samsung A71 yazdirin ve Enter’a basarak arama yaptirin

        WebElement AramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions=new Actions(driver);

        actions
                .click(AramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        ReusableMethods.bekleMethodu(3);

        //        4- aramanin gerceklestigini test edin

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedKelime="Samsung A71";
        String actualSonucYazisi= sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }
}
