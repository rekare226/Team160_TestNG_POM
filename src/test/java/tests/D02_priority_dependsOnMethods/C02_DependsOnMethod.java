package tests.D02_priority_dependsOnMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_DependsOnMethod {

 // 3 farkli test methodu olusturup,asagidaki gorevleri yapin
 //1-testotomasyonu anasayfaya gidip url'nin testotomasyonu icerdigini test edin
 //2-phone icin arama yapip urun bulunabildiğini test edin
 //3-ilk urun tiklayı,urun bulunabildiğini test edin
 //ilk urunu tiklayıp,urun isminde case sensetive olmadan "phone" bulundugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setUp(){
      driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void anasayfaTesti(){
     //1- testotomasyonu anasayfaya gidip
     driver.get("https://www.testotomasyonu.com");
     //2- url'nin testotomasyonu icerdiğini test edin
     String expectedYazi="testotomasyonu";
     String actualYazi=driver.getCurrentUrl();
     Assert.assertTrue(actualYazi.contains(expectedYazi));
    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){

        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        List<WebElement> phoneAramaSonucuList=driver.findElements(By.xpath("//*[@*='prod-img']"));
        int actualBulunanUrunSayisi=phoneAramaSonucuList.size();
        Assert.assertTrue(actualBulunanUrunSayisi>0);

    }

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){
   //ilk urunu tiklayip,
   driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
           .click();
//urun isminde case sensetive olmadan phone oldugunu test edin
String expectedIsimIcerik="phone";
String actualIsimIcerik=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText().toLowerCase();
Assert.assertTrue(actualIsimIcerik.contains(expectedIsimIcerik));

}










}
