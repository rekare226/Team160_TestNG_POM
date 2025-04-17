package tests.D06_driveClassDinamikYapma;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_AlisverisTesti {

    TestOtomasyonuPage testOtomasyonuPage;

    @Test(groups ="E2E")
    public void alisverisTesti(){
   //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
   //2- belirlenmis arama kelimesi için arama yapin
       testOtomasyonuPage=new TestOtomasyonuPage();
       testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
    //3- Listelenen sonuclardan ilkini tıklayın
        ReusableMethods.bekle(2);
    testOtomasyonuPage.bulunanUrunElementleriList
            .get(0)
            .click();

    //4- urun ismini kaydedin ve urunu sepete ekleyin
    String ilkUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText();

    //5-your card linkine tıklayın
        ReusableMethods.bekle(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(1);
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();",testOtomasyonuPage.addtoCardButonu);



    //your card linkine tiklayın
        ReusableMethods.bekle(1);
        jse.executeScript("arguments[0].click();",testOtomasyonuPage.yourCardButonu);

 //6- kaydettiğimiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
 String sepettekiUrunIsmi=testOtomasyonuPage.sepettekiUrunElementi.getText();
        Assert.assertEquals(sepettekiUrunIsmi, ilkUrunIsmi);

        //7 sayfayi kapatin
        Driver.quitDriver();


    }




}
