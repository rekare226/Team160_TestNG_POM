package tests.D01_IlkTestVeTanitim;

import org.testng.annotations.Test;
import utilities.Driver;

public class C03_DriverClassKullanimi {

    @Test
    public void test01(){

    //driver yerine artik DriverClass indaki getdriver kullanilicak
        Driver.getDriver().get("https://www.testotomasyonu.com");


    }
}
