package tests.D04_pageClassKullanimi;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_PositiveLoginTesti {

    @Test
    public void positiveLoginTesti(){
    /*
     testlerimizi DINAMIK yapmak ve test datalarina KOLAY ERISMEK icin
     test datalarıni confıguration.properties dosyasina yazipihtiyacimiz
     oldugunda oradan almak istiyoruz

     Java ile o bilgilere ulasmak icin once dosya yolunu almamiz
     sonra oradaki bilgileri okumamız bilgiler icerisinde
     ihtiyacimiz olan "toUrl", "toGecerliEmail"
     gibi bilgileri diger bilgilerden ayirip
     alip bu test class'ina  getirmemiz tek satirla olabilecek bir islem degildir

     Bu uzun islemi bizim adimiza yapip verdigimiz "toUrl", "toGecerliEmail" gibi gecerli key'lerin
     karsisindaki valueleri alip bize getirecek hazir bir method olusturalım

     */

    //1-https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get("https://www.testotomasyonu.com/");

    //2-account linkine basin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();

    //3-Kullanici email'i olarak alican@gmai.com girin
     testOtomasyonuPage.testotomasyonuEmail.sendKeys("alican@gmail.com");

    //4-Kullanici sifresi olarak gecerli pasword olarak 12345 girin
    testOtomasyonuPage.testotomasyonuPassWord.sendKeys("12345");

    //Login butonuna basarak login olun
    testOtomasyonuPage.testotomasyonuSignButonu.click();

    //Basarili olarak giris yapilabildiğini test edin
//        String expectedLogoutYazi="Logout";
//        String actualLogoutYazisi=testOtomasyonuPage.tesotomasyouLogoutYazisi.getText();
//        Assert.assertEquals(expectedLogoutYazi,actualLogoutYazisi);
        Assert.assertTrue(testOtomasyonuPage.tesotomasyouLogoutYazisi.isDisplayed());

    //Logout olun
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

// JavaScript ile click
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", testOtomasyonuPage.tesotomasyouLogoutYazisi);

// sayfayı kapat
        Driver.quitDriver();





    }








}
