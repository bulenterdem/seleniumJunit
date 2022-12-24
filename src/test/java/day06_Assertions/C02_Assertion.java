package day06_Assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
        JUnit frameworku calistirilan testlerin passed veya fail olmasini raporlar
        Ancak raporlamanin dogru sonuc vermesi icin
        testlerin Assert class indaki hazir methodlarla yapilmasi gerekir

        Eger Assert class kullanlmazsa JUnit kodlarin sorunsuz olarak calisip bittigini raporlar

        C01 de testleri if-else ile yaptigimiz icin
        Testler failed olsa da kodlar sorunsuz calistigi icin testler yesil tik olarak isaretlendi

     */

    int P1yas=60;
    int P2yas=66;
    int P3yas=70;

    @Test
    public void test01(){
        // emekli yasi 65 olduguna gore
        //P2 nin emekli olabilecegini test edin

        Assert.assertTrue(P2yas>65);

    }

    @Test
    public void test02(){
        // emekli yasi 65 olduguna gore
        //P1 nin emekli olamayacagi test edin

        Assert.assertFalse(P1yas>65);

    }

    @Test
    public void test03(){
        // emekli yasi 65 olduguna gore
        //P3 nin emekli olabilecegini test edin

        Assert.assertFalse("Girilen yas 65 den kucuk olmadigindan emekli olabilir",P3yas>65);

    }
}
