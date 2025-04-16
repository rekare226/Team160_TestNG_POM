package tests.D04_pageClassKullanimi;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_FacebookTesti {

    @Test
    public void negatifLoginTesti(){
        //1- https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        //Cookies cıkıyırsa kabul edin

        //POM'a uygun olarak email,sifre,ve giris yap butonunu locate edin
        FacebookPage facebookPage=new FacebookPage();
        // Faker class'ini kullanarak email ve sifre degerlerini yazdirip,giris butonuna basın
        Faker faker=new Faker();
        facebookPage.facebookEmail.sendKeys(faker.internet().emailAddress());
        facebookPage.facebookPassword.sendKeys(faker.internet().password());
        facebookPage.facebookgirisButonu.click();

        //başarılı giriş yapilamadıgını test edin

        ReusableMethods.bekle(1);
        Assert.assertTrue(facebookPage.facebookEmail.isDisplayed());
        Driver.quitDriver();



    }











}
