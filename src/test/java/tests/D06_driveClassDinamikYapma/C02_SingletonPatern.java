package tests.D06_driveClassDinamikYapma;

import org.testng.annotations.Test;

public class C02_SingletonPatern {

    @Test
    public void test01(){
        //testotomasyonu anasayfasına gidin
       // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        /*
        Bir class dan obje olusturulabilmesini engellemek  icin kullanabilecek farkli yöntemler var
        POM!i hazirlayanlar bu alternatifler içerisinde Singleton pattern'i tercih etmişlerdir

        Singleton pattern obje olusturmayı engellemek icin Constructor'i sinirlama uzerine kurulmustur.
        Boylece Driver class'ini istenen yontem disinda obje olusturularak KULLANILMAZ

        Page Object Model'de her sayfa class'ı test boyunca tek bir defa oluşturulmalı ve
         aynı WebDriver kullanılmalı. Singleton pattern de işte bu ihtiyacı karşılıyor.

         */

        //JUnitte önce expected sonra actual iken TestNG de ise önce actual sonra expected dir....
        //test otomasyonunun temel amacı Test Case'lerde belirlenen her bir adımın test edilemesidir...

    }





}
