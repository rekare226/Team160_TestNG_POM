package tests.D03_pageObjectModel_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_BasicDriverClassKullanma {



    @Test
    public void driverClassTestIlkTest(){
        /*
        TestNG POM framework ile temel hedefimiz test class'inda surekli kullandigimiz

        1-WebDriver objesi
        2-Locate'ler
        3-Test data'lari (kullanici adi,sifre....) gibi verileri tek bir yere yazip,

        test class'larida dinamik kod kullanarak,yapilan guncellemelerde kolay bir şekilde yeni degeri
        tanimlamayı mumkun kılmak

         */

        /*







         */


    //test otomasyonu anasayfaya gidin

        Driver.getDriver().get("https://www.wisequarter.com");
        Driver.getDriver().get("https://www.youtube.com");
        Driver.getDriver().get("https://www.testotomasyonu.com");



    //Arama kutusunu locate edip
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("global-search"));

    //phone icin arama yapin
aramaKutusu.sendKeys("phone"+ Keys.ENTER);

    //sayfayi kapatin

        ReusableMethods.bekle(2);
        Driver.quitDriver();





    }








}
