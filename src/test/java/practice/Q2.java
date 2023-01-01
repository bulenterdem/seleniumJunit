package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q2 extends TestBase {

    @Before

    public void beforeTest(){
        driver.get("http://www.bestbuy.com");

    }




    @Test
    public void title(){

         //  http://www.bestbuy.com 'a gidin,
        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin

        String expectedTitle = "Best";
        String actualTitle = driver.getTitle();

        assertTrue(actualTitle.contains(expectedTitle));
        // Ayrica Relative Locator kullanarak;




    }

    @Test
    public void logolinktest(){

        WebElement Helloelement= driver.findElement(By.xpath("//div[text()='Hello!']"));

        WebElement logoelemnti=
                driver.findElement(RelativeLocator.with(By.xpath("(//img [@ class='logo'])[1]")).above(Helloelement));

        assertTrue(logoelemnti.isDisplayed());

      //  logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin

    }

    @Test
    public void mexicolinktest(){

        //  Ayrica Relative Locator kullanarak;
        //  mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

        WebElement unitedStateElemnti= driver.findElement(By.xpath("(//h4[text()='United States'])[1]"));

        WebElement mexicoElemnti=
                driver.findElement(RelativeLocator.with(By.xpath("(//h4[text()='Mexico'])[1]"))
                        .toRightOf(unitedStateElemnti));


             boolean iceriyormu= mexicoElemnti.isDisplayed();

             assertTrue(iceriyormu);


    }
}
