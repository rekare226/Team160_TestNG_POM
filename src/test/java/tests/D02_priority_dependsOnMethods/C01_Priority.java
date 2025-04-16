package tests.D02_priority_dependsOnMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {


    WebDriver driver;
   //uc farkli test methodu olusturun

   //testotomasyonu,wisequarter ve bestbuy sitelerine gidip

   //url'nin testotomasyonu, wisequarter ve bestbuy kelimeleri icerdiğini test edin

   //ve  windowlari kapatın

   @BeforeMethod
   public void setUp(){
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   }

    @AfterMethod
    public void teardown(){
       driver.quit();
    }

  @Test(priority = 1)
  public void testotomasyonuTest() throws InterruptedException {

       driver.get("https://www.testotomasyonu.com");
       String expectedUrlIcerik="testotomasyonu";
       String actualUrl=driver.getCurrentUrl();
      Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
      Thread.sleep(1000);



  }

 @Test(priority = 2)
 public void wisequarterTest() throws InterruptedException {

    driver.get("https://www.wisequarter.com");
    String expectedUrlIcerik="wisequarter";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    Thread.sleep(1000);

}

 @Test(priority = 3)
 public void bestbuy() throws InterruptedException {

        driver.get("https://www.bestbuy.com");
        String expectedUrlIcerik="bestbuy";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);

    }


}
