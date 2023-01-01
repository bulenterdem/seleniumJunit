package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class S05_TekrarTesti3 extends TestBase {

    @Test
    public void Test01(){

        //amazon gidin
      driver.get("http://www.amazon.com");

      //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın

        WebElement AllDropDownElementi= driver.findElement(By.xpath("//select[@ id='searchDropdownBox']"));

        AllDropDownElementi.click();

        ReusableMethods.bekleMethodu(3);
        Select select=new Select(AllDropDownElementi);

        List<WebElement> AllWebElementListesi =select.getOptions();

        System.out.println(AllWebElementListesi);

        ReusableMethods.bekleMethodu(3);


        //3- dropdown menude 40 eleman olduğunu doğrulayın
        int actualAllMenuElemanSayisi = AllWebElementListesi.size();
        int expectedAllMenuElemanSayisi=28;

        Assert.assertEquals(expectedAllMenuElemanSayisi,actualAllMenuElemanSayisi);


    }
    @Test
    public void Test02(){

        //1-dropdown menuden elektronik bölümü seçin
        driver.get("http://www.amazon.com");
        WebElement AllDropDownElementi= driver.findElement(By.xpath("//select[@ id='searchDropdownBox']"));
        Select select=new Select(AllDropDownElementi);
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone" + Keys.ENTER);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin

            String expectedSonuc="iphone";
            String actualSonuc=driver.findElement(By.xpath("//span[@ class='a-color-state a-text-bold']")).getText();
            Assert.assertTrue(actualSonuc.contains(expectedSonuc));

            ReusableMethods.bekleMethodu(3);


        //4- ikinci ürüne relative locater kullanarak tıklayin

       WebElement ikinciurun=driver.findElement(By.xpath("//div[@ data-index='2' ]"));

       ikinciurun.click();





        ReusableMethods.bekleMethodu(5);

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

      String urunFiyatElementi=driver.findElement(By.xpath("(//span[@ class='a-offscreen'])[6]")).getText();
       String  titleurun = driver.findElement(By.xpath("//span[@ id='productTitle']")).getText();
        driver.findElement(By.xpath("//input[ @id='add-to-cart-button']")).click();

        ReusableMethods.bekleMethodu(3);

    }

    @Test
    public void Test03(){

        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.amazon.com");

        //2-dropdown’dan bebek bölümüne secin
        WebElement AllDropDownElementi= driver.findElement(By.xpath("//select[@ id='searchDropdownBox']"));
        Select select=new Select(AllDropDownElementi);
        select.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller" + Keys.ENTER);

        ReusableMethods.bekleMethodu(3);

        //4-sonuç yazsının puset içerdiğini test edin

        String expectedSonuc2="stroller";
        String actualSonuc2=driver.findElement(By.xpath("//span[@ class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(actualSonuc2.contains(expectedSonuc2));
        //5-üçüncü ürüne relative locater kullanarak tıklayin

        driver.findElement(By.xpath("(//span[@ class='a-size-medium a-color-base a-text-normal'])[3]")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

      //  WebElement titleElementi= driver.findElement(By.xpath("//span[@ id='productTitle']"));

     //   WebElement fiyatElementi= driver.findElement(By.xpath("//span[@ class='a-price aok-align-center']"));

     ///   System.out.println(titleElementi.getText());
     //   System.out.println(fiyatElementi.getText());

        driver.findElement(By.xpath("//input[@ id='add-to-cart-button']")).click();
    }
}
