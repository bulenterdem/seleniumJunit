package day09_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;

public class C02_DrogAndDrop extends TestBase {

    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMeElement= driver.findElement(By.xpath("//div[@ id='draggable']"));

        WebElement birakilacakAlanElemnti=driver.findElement(By.xpath("//div[@ id='droppableExample-tabpane-simple'] "));

        Actions actions=new Actions(driver);

        actions.dragAndDrop(dragMeElement,birakilacakAlanElemnti).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedyaziElemnti=driver.findElement(By.xpath("//div[@ id='droppableExample-tabpane-simple'] "));

        Assert.assertTrue((droppedyaziElemnti.isDisplayed()));


        ReusableMethods.bekleMethodu(3);


    }
}
