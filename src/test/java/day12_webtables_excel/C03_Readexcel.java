package day12_webtables_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_Readexcel {

     @Test
    public void Test01() throws IOException {

         // ulkeler excelindeki sayfa 1 gidecek sekilde ayarlari yapalim


         String dosyayolu= "src/test/java/day12_webtables_excel/ulkeler.xlsx";

          FileInputStream fis = new FileInputStream(dosyayolu);
         Workbook workbook= WorkbookFactory.create(fis);

         // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
         System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

         // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
         String istenenHucreStr=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
         System.out.println(istenenHucreStr);

         // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

         String actualBaskent=workbook.getSheet("sayfa1").getRow(1).getCell(3).toString();
         String expexctedBaskent="Kabil";

         Assert.assertEquals(expexctedBaskent,expexctedBaskent);


         // - Satir sayisini bulalim

         System.out.println("satir sayisi :"+(workbook.getSheet("sayfa1").getLastRowNum()+1));

         // - Fiziki olarak kullanilan satir sayisini bulun
         //  bunun icin sayfa 2 deki son satir indexini ve fiziki kullanila satir sayisini bulalim

         System.out.println("2. sayfa satir indexi : "+ workbook.getSheet("Sayfa2").getLastRowNum());

         System.out.println("Fiziki kullanilan satir sayisi :" + workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

         // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

         // ulke ismi ingilizce==> key' geriye kalan 3 bilgi ise birlestirilerek value olsun

         Map<String,String> ulkelerMap=new TreeMap<>();

         int sonsatirIndexi=workbook.getSheet("sayfa1").getLastRowNum();

         String key="";
         String value="";

         for (int i = 0; i <=sonsatirIndexi; i++) {

             key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
             value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                     workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                     workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

             ulkelerMap.put(key,value);

         }

         System.out.println(ulkelerMap);

     }
}
