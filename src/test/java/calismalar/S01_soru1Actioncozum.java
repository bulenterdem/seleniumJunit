package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

public class S01_soru1Actioncozum {



    @Test
    public void test01 (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("http://automationexercise.com");

       WebElement signupkutus= driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        Actions actions=new Actions(driver);
        actions.click(signupkutus).perform();

        WebElement nameEleman = driver.findElement(By.xpath("//input[@ data-qa='signup-name']"));
       actions.click(nameEleman)
               .sendKeys("kamil")
               .sendKeys(Keys.TAB)
               .sendKeys("bulenterdem11@gmail.com")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER)
               .perform();

       WebElement titlebutonu=driver.findElement(By.xpath("(//div[@class=\'radio-inline\'])[1]"));
       actions.click(titlebutonu)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("12345")
               .sendKeys(Keys.TAB)
               .sendKeys("20")
               .sendKeys(Keys.TAB)
               .sendKeys("may")
               .sendKeys(Keys.TAB)
               .sendKeys("1998")
               .sendKeys(Keys.TAB)
               .click()
               .sendKeys(Keys.TAB)
               .click()
               .sendKeys(Keys.TAB)
               .sendKeys("Bulent")
               .sendKeys(Keys.TAB)
               .sendKeys("san")
               .sendKeys(Keys.TAB)
               .sendKeys("sana")
               .sendKeys(Keys.TAB)
               .sendKeys("sanayiii")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("Canada")
               .sendKeys(Keys.TAB)
               .sendKeys("dallas")
               .sendKeys(Keys.TAB)
               .sendKeys("teksas")
               .sendKeys(Keys.TAB)
               .sendKeys("05100")
               .sendKeys(Keys.TAB)
               .sendKeys("0510055545")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER).perform();



        String expectedyazi="ACCOUNT CREATED";
        String actualyazi= driver.findElement(By.xpath("//h2[@data-qa='account-creted']")).getText();

        Assert.assertEquals(expectedyazi,actualyazi);

        driver.close();




    }



}
