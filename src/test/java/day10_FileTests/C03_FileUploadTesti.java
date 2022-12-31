package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {


    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");


        //2.chooseFile butonuna basalim
       //3.Yuklemek istediginiz dosyayi secelim.

        /*
            Bu gorevi yapabilmek icin choose file butonuna basildiginda acilan
            bilgisayarimizdaki file dosyalarini click yapabilmemiz gerekir
            ancak selenium bilgisayarimizdaki dosyalari click yapamaz

            Bunun icin soyle bir cozum var var

            1. choosefile butonunu locate edin
            2. upload edileck dosyanin dosya yolunu olusturun
            3. chooseFile butonuna sendkeys ile dosya yolunu gonderin

         */

        WebElement choosefileElement= driver.findElement(By.xpath("//input[@id='file-upload']"));

        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Belgeler\\merhabajava.docx";

        choosefileElement.sendKeys(dosyaYolu);

        //4.Upload butonuna basalim.

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();


        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement FileUploadedelementi= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(FileUploadedelementi.isDisplayed());

        ReusableMethods.bekleMethodu(3);
    }
}
