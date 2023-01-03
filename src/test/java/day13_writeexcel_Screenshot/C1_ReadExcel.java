package day13_writeexcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C1_ReadExcel {

    @Test
    public void Test01() throws IOException {

        //excel dosyalari bilgisayarimizda oldugu icin
        // java'dan FileInputstream class'i yardimiyla ulasacaz

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

        // satir ve sutun bilgisini parametre olarak alip o hucredeki bilgiyi yazdiran
        // bir method olusturalim

        datayazdir(25,2);
        datayazdir(14,3);

    }

    private void datayazdir(int satir, int sutun) throws IOException {
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));

    }
}
