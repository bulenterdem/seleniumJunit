package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String dosyayolu="C:\\Users\\bulen\\OneDrive\\Belgeler\\merhabajava.docx";

        FileInputStream fis = new FileInputStream(dosyayolu);

          /*
            File testlerinde genellıkle dowloads'a indırılecek bır dosyanın ınırıldıgını test etmek veya
             bır dosyanın web'e yuklenebıldıgını test etmek ısterız
            Ancak herkesın bılgısayarının ısmı , kullanıcı ısımlerı gıbı farklılıklar olacagınsan testler
            tek bır bılgısayarda calısacak  gibi yazılmak zorunda kalırnır.

             Bu karışıklıgın önüne geçebilmek için Java iki basit kod blogu sunmuş:
            System.out.println(System.getProperty("user.dir"));  // o anca çalışan dosyanın (C01_FileInputStream)
             yolunu verir
            System.out.println(System.getProperty("user.home")); //Kullanıcının temel path'ini verir.

     */

        System.out.println(System.getProperty("user.dir"));
        // o anda calisan dosyanin (co1_FileInputStream) yolunu verir
        // C:\Users\bulen\IdeaProjects\com.Team105JUnit

        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path'ini verir
        //C:\Users\bulen

        // masausutune gitmek istersek
        // //C:\Users\bulen  + /Destkop eklemiz yeterlidir

        //download a gitmek istersek
        // //C:\Users\bulen +/ download eklememiz gerekir

        // kodlarimizn dinamik olmasi yani kisinin bilgisayarindaki kullanici adi gibi detaylara
        // takilmamasi icin file teslerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayrdan alacak sekilde olustururuz

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Belgeler\\merhabajava.docx";



    }
}
