package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q3 extends TestBase {

    @Test
    public void test01(){

        //2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        WebElement homepageElementi= driver.findElement(By.xpath("//h1[text()='Exercise']"));

        assertTrue(homepageElementi.isDisplayed());


        //4. Click on 'Contact Us' button

        driver.findElement(By.linkText("Contact us")).click();


        //5. Verify 'GET IN TOUCH' is visible

        WebElement getInTouchElementi= driver.findElement(By.xpath("(//h2[@ class='title text-center'])[2]"));

        assertTrue(getInTouchElementi.isDisplayed());

        //6. Enter name, email, subject and message

        WebElement isimElementi=driver.findElement(By.xpath("//input[@ name='name'] "));
        Actions actions=new Actions(driver);

        actions.click(isimElementi).sendKeys("bulent")
                .sendKeys(Keys.TAB)
                .sendKeys("Bul@gmaail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("selenium")
                .sendKeys(Keys.TAB)
                .sendKeys("merhaba").perform();


        //7. Upload file

        WebElement uploadElement=driver.findElement(By.xpath("//input[@ name='upload_file']"));
        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Belgeler\\merhabajava.docx";

       uploadElement.sendKeys(dosyaYolu);

        //8. Click 'Submit' button

        driver.findElement(By.xpath("//input[@name='submit' ]")).click();

        //9. Click OK button

        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        WebElement alert =driver.findElement(By.xpath("//div[@ class='status alert alert-success']"));

        assertTrue(alert.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully

        driver.findElement(By.xpath("//a [@class='btn btn-success' ]")).click();
        //     */
    }
}
