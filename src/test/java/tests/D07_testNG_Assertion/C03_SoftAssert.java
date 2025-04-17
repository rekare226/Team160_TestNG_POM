package tests.D07_testNG_Assertion;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v132.overlay.model.LineStyle;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppSecurityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C03_SoftAssert {

    @Test
    public void test01(){
    //1."http://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webappsecurityUrl"));
    //2.webappsecurity ana sayfaya gittiğinizi dogrulayın
        String expectedUrl=ConfigReader.getProperty("webappsecurityUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"url beklenenden farkli");


   //3. sign in butonuna basin
        WebAppSecurityPage webAppSecurityPage=new WebAppSecurityPage();
        webAppSecurityPage.anasayfaSignButonu.click();
   //4. Login kutusuna "username" yazın
        webAppSecurityPage.loginKutusu
                           .sendKeys(ConfigReader.getProperty("toLoginKutusuWebApp"));
   //5.password kutusuna "password" yazin
   webAppSecurityPage.passwordKutusu.sendKeys("password");
   //6.Sign in tusuna  basin
        ReusableMethods.bekle(1);
    webAppSecurityPage.signInButonu.click();
   //7.Back tusuna basin
        Driver.getDriver().navigate().back();
   //8.girişyapılabildiğini doğrulayın
        softAssert.assertTrue(webAppSecurityPage.settingsMenu.isDisplayed());
   //9.Online banking menusunu tiklayin
   webAppSecurityPage.onlineBankingButton.click();
   //10.pay Bills sayfasina gidin
        ReusableMethods.bekle(2);
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",webAppSecurityPage.payBillsPage);
        jse.executeScript("arguments[0].click();",webAppSecurityPage.payBillsPage);
// jse.executeScript("arguments[0].click();",isitmeKaybiCheckBox);
//jse.executeScript("arguments[0].scrollIntoView(true);",isitmeKaybiCheckBox);
   //11."Purchase Foreign Currency" tusuna basin
        ReusableMethods.bekle(2);
jse.executeScript("arguments[0].scrollIntoView(true);",webAppSecurityPage.purchaseForeign);
        jse.executeScript("arguments[0].click();",webAppSecurityPage.purchaseForeign);

//12.Currency dropdown menusune erişebilir oldugunu test edin
        softAssert.assertTrue(webAppSecurityPage.currencyMenu.isEnabled(),
                "Cureency menusu erişebilir degil");

//13."Currency" dropdown menusunden Eurozone'u secin
//jse.executeScript("arguments[0].click()",webAppSecurityPage.currencyMenu);
        Select select = new Select(webAppSecurityPage.currencyMenu);
        select.selectByVisibleText("Eurozone (euro)");
//14. "Eurozone (euro)" secildigini dogrulayin
        String actualSelected = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSelected, "Eurozone (euro)", "Eurozone (euro) secilemedi");
//15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOption=16;
        int actualOption=select.getOptions().size();
        softAssert.assertEquals(actualOption,expectedOption,
                "Dropdown menude 16 option bulunmuyor");
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        String expectedDropDownIcerik="Canada (dollar)";
        List<String> ddmOptionList=ReusableMethods.listiStringListeDondur(select.getOptions());
        softAssert.assertTrue(ddmOptionList.contains(expectedDropDownIcerik),
                "Dropdown menude Canada (dollar) bulunmuyor");

        ReusableMethods.bekle(3);
        softAssert.assertAll();
        Driver.quitDriver();

    }


}
