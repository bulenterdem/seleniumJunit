package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        String Dosyayolu= "C:\\Users\\bulen\\IdeaProjects\\com.Team105JUnit\\src\\test\\java\\day12_webtables_excel\\ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(Dosyayolu);




        Workbook workbook = WorkbookFactory.create(fis);

        // workbook icersinde birden fazla sayfa olabilir
        // istedigimi sayfaya gidelim

        Sheet sheet = workbook.getSheet("sayfa1");

        // Angola yazdirmak istedigimiz icin 5.satira gidelim

        Row row= sheet.getRow(5);

        // 5.satirdaki  2/indexe gidelim

        Cell cell= row.getCell(2);

        System.out.println(cell);


    }


}
