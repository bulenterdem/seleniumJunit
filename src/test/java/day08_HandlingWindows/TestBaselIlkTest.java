package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class TestBaselIlkTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");


        String expectedKelime="amazon";
        String actualKelime=driver.getCurrentUrl();

       Assert.assertTrue(actualKelime.contains(expectedKelime));

        ReusableMethods.bekleMethodu(3);
    }
}
