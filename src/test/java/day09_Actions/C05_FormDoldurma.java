package day09_Actions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurma extends TestBase {


    @Test
    public void Test01() {


        driver.get("https://tr-tr.facebook.com/");

        WebElement YeniHesapElementi =
                driver.findElement(By.xpath("//a[@ class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));

        YeniHesapElementi.click();

        WebElement IsimElementi = driver.findElement(By.xpath("//input[@name='firstname']"));

         Actions actions=new Actions(driver);

        Faker faker =new Faker();

        String mailadresi=faker.internet().emailAddress();

        actions.click(IsimElementi)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailadresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailadresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Ara")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        WebElement KaydolButonu= driver.findElement(By.name("websubmit"));
        KaydolButonu.click();

      //  WebElement hatamesajelemnti= driver.findElement(By.id("reg_error_inner"));

       // Assert.assertTrue(hatamesajelemnti.isDisplayed());


        ReusableMethods.bekleMethodu(20);









    }

}
