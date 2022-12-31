package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01_MouseActions extends TestBase {

    @Test
    public void testo1() {

        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions= new Actions(driver);
        WebElement ciziliAlanElementi= driver.findElement(By.xpath("//div[@id='hot-spot']"));

        actions.contextClick(ciziliAlanElementi).perform();
        ReusableMethods.bekleMethodu(2);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedalertYazisi="You selected a context menu";
        String actualalertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedalertYazisi,actualalertYazisi);

        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        String IlksayfaWHD=driver.getWindowHandle();
        System.out.println(IlksayfaWHD);

        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String>ikisayfaWHDSeti=driver.getWindowHandles();

        String IkinciWhd="";

        for (String eachWhd:ikisayfaWHDSeti
        ) {
            if (!eachWhd.equals(IlksayfaWHD)) {
                IkinciWhd=eachWhd;
            }
        }

        driver.switchTo().window(IkinciWhd);

        String expectedYeniSayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);


        ReusableMethods.bekleMethodu(5);
        }


    }

