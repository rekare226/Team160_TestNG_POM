package tests.D07_testNG_Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_CokluAssertion {

    @Test(groups ="E2E")
    public void ilkUrunIsimtesti(){
        //1-testotomasyonu anasayfaya gidip

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik="testotomasyonu";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url verilen içeriğe sahip değil");

        //2-nutella icin arama yapip
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        //urun  bulunamadigi test edin
        String arananUrununSayisi=testOtomasyonuPage.aramaSonucuUrunSayisiElementi.getText();
        arananUrununSayisi=arananUrununSayisi.replaceAll("\\D","");
        int UrununSayisi=Integer.parseInt(arananUrununSayisi);
        Assert.assertEquals(UrununSayisi,0);

//        int actualBulunanurunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
//        Assert.assertEquals(actualBulunanurunSayisi,0);
//        Driver.quitDriver();
        //actual bulunan urun sayisi için lisy yöntemi kullanırsak >Liste eklenecek web element bulmak için
        //implicity wait suresince bekleyecektir...bu yüzden bu yöntemi yoruma aldık

        //3-belirlenen arama kelimesi icin yapip
testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);

        //urun bulunabildigini test edin
        arananUrununSayisi=testOtomasyonuPage.aramaSonucuUrunSayisiElementi.getText();
        arananUrununSayisi=arananUrununSayisi.replaceAll("\\D","");
        UrununSayisi=Integer.parseInt(arananUrununSayisi);
        Assert.assertNotEquals(arananUrununSayisi,0);

//4-ilk urunu tiklayıp,
        ReusableMethods.bekle(1);
        testOtomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();

//urun isminde case sensetive olmadan aranacak kelime bulundugunu test edin
    String expectedIsimIcerik=ConfigReader.getProperty("toAranacakKelime");
    String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();
    Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

//5- sayfayi kapatin
Driver.quitDriver();

    }




















    //urun isminde case sensetive olmadan aranacak kelime bulundugunu test edin


    //5-sayfayı kapatın...





}
