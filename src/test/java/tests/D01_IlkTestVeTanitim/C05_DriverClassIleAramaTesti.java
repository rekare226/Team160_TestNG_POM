package tests.D01_IlkTestVeTanitim;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C05_DriverClassIleAramaTesti {
//1- testotomasyonu anasayfaya gidin
//2- phone icin arama yapin
//3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin
//4- ilk urunu tiklayin
//5- acilan urun sayfasinda, urun isminde case sensitive olmadan phone bulundugunu test edin.

 @Test
 public void aramaTesti(){
     Driver.getDriver().get("https://www.testotomasyonu.com");

     WebElement aramaKutusu=Driver.getDriver().findElement(By.id("global-search"));
     aramaKutusu.sendKeys("phone"+ Keys.ENTER);
     List<WebElement> bulunanUrunElementleriListesi=
             Driver.getDriver().findElements(By.className("prod-img"));


 }



}
