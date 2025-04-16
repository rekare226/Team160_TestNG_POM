package tests.D03_pageObjectModel_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverClassKullanimi {

    //uc farkli test methodu olusturun
    //testotomasyonu,wisequarter ve bestbuy sitelerine gidip
    //url'in bu kelimeleri icerdigini test edin
    //ve windowlari kapatin


 @Test
 public void testotomasyonuTest(){

     Driver.getDriver().get("https://www.testotomasyonu.com");

     String expectedUrlIcerik="testotomasyonu";
     String actualUrlIcerik=Driver.getDriver().getCurrentUrl();
     Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
     ReusableMethods.bekle(1);
     Driver.quitDriver();

 }

 @Test
 public void wisequarterTest(){

     Driver.getDriver().get("https://www.wisequarter.com");

     String expectedUrlIcerik="wisequarter";
     String actualUrlIcerik=Driver.getDriver().getCurrentUrl();
     Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
     ReusableMethods.bekle(1);
     Driver.quitDriver();

    }

 @Test
 public void bestbuyTest(){

     Driver.getDriver().get("https://www.bestbuy.com");

     String expectedUrlIcerik="bestbuy";
     String actualUrlIcerik=Driver.getDriver().getCurrentUrl();
     Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
     ReusableMethods.bekle(1);
     Driver.quitDriver();

    }



}
