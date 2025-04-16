package tests.D01_IlkTestVeTanitim;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_quitDriver {

  @Test
  public void test01(){

      Driver.getDriver().get("https://www.youtube.com");



  }

    @Test
    public void test02(){

        //driver yerine artik DriverClass indaki getdriver kullanilicak
        Driver.getDriver().get("https://www.testotomasyonu.com");

    }


}
