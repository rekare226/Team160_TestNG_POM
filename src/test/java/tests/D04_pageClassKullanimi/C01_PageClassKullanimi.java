package tests.D04_pageClassKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.TestOtomasyonuPage;
import utilities.Driver;

import java.util.List;

public class C01_PageClassKullanimi {


    @Test
    public void anasayfaTesti(){

     //1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get("https://www.testotomasyonu.com");


     //url'in testotomasyonu icerdigini test edin
        String expectingUrlIcerigi="testotomasyonu";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectingUrlIcerigi));

    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

      //urun bulunabildigini test edin

     int actualBulunanUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
     Assert.assertTrue(actualBulunanUrunSayisi>0);

    }

    @Test(dependsOnMethods ="phoneAramaTesti")
    public void ilkUrunTesti(){
    TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
    testOtomasyonuPage.bulunanUrunElementleriList
            .get(0)
            .click();

    //cıkan urun isminde case sensetive olmadan phone oldugunu test edin
        String expecdekIcerik="phone";
        String actualUrunIsmi=testOtomasyonuPage
                                      .urunIcindekiYazi
                                        .getText()
                                         .toLowerCase();
        Assert.assertTrue(actualUrunIsmi.contains(expecdekIcerik));
        Driver.quitDriver();
    }






}
