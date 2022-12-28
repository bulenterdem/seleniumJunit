package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class S02_HandleDropDown3 {

    /*
            1. http://zero.webappsecurity.com/ Adresine gidin
            2. Sign in butonuna basin
            3. Login kutusuna “username” yazin
            4. Password kutusuna “password.” yazin
            5. Sign in tusuna basin
            6. Pay Bills sayfasina gidin
            7. “Purchase Foreign Currency” tusuna basin
            8. “Currency” drop down menusunden Eurozone’u secin
            9   . “amount” kutusuna bir sayi girin
            10. “US Dollars” in secilmedigini test edin
            11. “Selected currency” butonunu secin
            12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
                13. “Foreign currency */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//button [@id='signin_button']")).click();

        driver.findElement(By.xpath("//input[@ id='user_login']")).sendKeys("username");

        driver.findElement(By.xpath("//input[@  id='user_password']")).sendKeys("password");


        driver.findElement(By.xpath("//input[@ name='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("// li[@id='onlineBankingMenu' ]")).click();

        driver.findElement(By.xpath("//*[ @id='pay_bills_link']")).click();


        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencydropdown=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(currencydropdown);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2000");

        //10. “US Dollars” in secilmedigini test edin
        WebElement secim$=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse("seçili dolarlar",secim$.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin

        Thread.sleep(2000);
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        WebElement atama=driver.findElement(By.id("alert_content"));

        Thread.sleep(3000);


        String actuallkelime=atama.getText();


        String expectedKelime="Foreign currency cash was successfully purchased.";
        Assert.assertTrue(actuallkelime.contains(expectedKelime));



    }



}
