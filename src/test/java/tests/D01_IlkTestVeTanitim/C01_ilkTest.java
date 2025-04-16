package tests.D01_IlkTestVeTanitim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_ilkTest {

    WebDriver driver;
/*
1- Bir test class’i olusturun ilgili ayarlari yapin
2- https://www.testotomasyonu.com adresine gidin
3- urun arama kutusunu locate edin
4- arama kutusuna “shoe” yazdirin
5- arama islemini yapabilmek icin ENTER tusuna basin


 */

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

@Test

    public void test01(){
    driver.get("https://www.testotomasyonu.com");

    WebElement aramaKutusu=driver.findElement(By.id("global-search"));
    aramaKutusu.sendKeys("shoe");

}



}
