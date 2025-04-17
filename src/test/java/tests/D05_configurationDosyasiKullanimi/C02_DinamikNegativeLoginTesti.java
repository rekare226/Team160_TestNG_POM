package tests.D05_configurationDosyasiKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DinamikNegativeLoginTesti {

//1- https://www.testotomasyonu.com/ anasayfasina gidin

//2-account linkine basin

//3- 3 farkli test method'u olusturun

//-gecerli email,gecersiz password
//-gecersiz email, gecerlipassword
//-gecersiz email,gecersiz password.
//4-Login butonuna basarak login olmayi deneyin
//Basarili olarak giris yapildigini test edin
TestOtomasyonuPage testOtomasyonuPage;


@Test
public void gecersizSifreTesti(){
 //1- https://www.testotomasyonu.com/ anasayfasina gidin
    Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    testOtomasyonuPage=new TestOtomasyonuPage();

    //2-account linkine basin
    ReusableMethods.bekle(1);
    testOtomasyonuPage.accountButonu.click();

//3- 3 farkli test method'u olusturun
//-gecerli email,gecersiz password

testOtomasyonuPage.testotomasyonuEmail
        .sendKeys(ConfigReader.getProperty("toGecerliMail"));

testOtomasyonuPage.testotomasyonuPassWord
                .sendKeys(ConfigReader.getProperty("toGecersizSifre"));

//4-login butonu
    ReusableMethods.bekle(2);
  testOtomasyonuPage.testotomasyonuSignButonu.click();

//5-Basarili olarak Girlmediğini test edin
    //burada bir kabul u muz olacak eger basarılı giriş yapamıyorsak
    //email kutusu yada pasword hala görülemli
    Assert.assertTrue(testOtomasyonuPage.testotomasyonuEmail.isDisplayed());
    Driver.quitDriver();



}

@Test
public void gecersizEmailTesti(){
    //1-https://www.testotomasyonu.com/ anasayfasina gidin
    Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    testOtomasyonuPage=new TestOtomasyonuPage();
    //2-account linkine basin
    ReusableMethods.bekle(2);
    testOtomasyonuPage.accountButonu.click();
   //3- 3 farkli test method'u olusturun
  //-gecersiz email,gecerli password

    testOtomasyonuPage.testotomasyonuEmail.sendKeys(ConfigReader.getProperty("toGecersizMail"));
    testOtomasyonuPage.testotomasyonuPassWord.sendKeys(ConfigReader.getProperty("toGecerliSifre"));

    //4-login butonu
    ReusableMethods.bekle(2);
    testOtomasyonuPage.testotomasyonuSignButonu.click();

    //basarili olarak giriş yapılamdıgını test edin
    Assert.assertTrue(testOtomasyonuPage.testotomasyonuPassWord.isDisplayed());
    Driver.quitDriver();

}

@Test(groups = {"E2E","smoke","regresion"})
public void gecersizEmailGecersizPassWordTesti(){

    //1-https://www.testotomasyonu.com/ anasayfasina gidin
    Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    testOtomasyonuPage=new TestOtomasyonuPage();
    //2-account linkine basin
    ReusableMethods.bekle(2);
    testOtomasyonuPage.accountButonu.click();

    //3- 3 farkli test method'u olusturun
    //-gecersiz email,gecersiz password
    testOtomasyonuPage.testotomasyonuEmail.sendKeys(ConfigReader.getProperty("toGecersizMail"));
    testOtomasyonuPage.testotomasyonuPassWord.sendKeys(ConfigReader.getProperty("toGecersizSifre"));
    //4-login butonu
    ReusableMethods.bekle(2);
    testOtomasyonuPage.testotomasyonuSignButonu.click();
    //basarili olarak girlmediğini test edin

    Assert.assertTrue(testOtomasyonuPage.testotomasyonuEmail.isDisplayed());
Driver.quitDriver();
}

}
