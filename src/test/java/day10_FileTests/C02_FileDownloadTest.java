package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {


    @Test
    public void test01(){


        //2. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim

        driver.findElement(By.xpath("//a [text()='Facebookd.png']")).click();
        ReusableMethods.bekleMethodu(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // test icin oncelikle dosyanin indirildiginde dosyayolu ne olacak bunu olusturmaliyiz

        String dosyayolu=System.getProperty("user.home")+"\\Downloads\\Facebookd.png";

        // Bir dosyanin bilgisayarimizda var oldugunu yani (exist) test etmek icin
        // java daki Files class'indan yardim alacaz

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));


    }

    @Test
    public void test02 (){


        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Belgeler\\merhabajava.docx";


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }


}
