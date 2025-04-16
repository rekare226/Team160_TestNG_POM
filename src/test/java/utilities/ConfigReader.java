package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    /*
    Bu class'in 2 temel görevi var;
    1-configuration.properties dosyasindaki bilgileri okumak
    ConfigReader calistirildiğinda ONCELIKLE bu okuma isleminin yapılması için
    okuma islemini bir static blok icerisinde yapıyoruz....

     statik blok calistiğinda configuration.properties dosyasındaki tum key-value ikililerini
    okuyup class level'da bulunan "properties" objesine yukluyor

    2-ilk gorevde configuration.properties dosyasindaki
    tum key-value ikilileri okunup properties objesine yuklendi

    getProperty(istenenKey) method'u ise properties objesine
    yuklenen key-value'lerden bizim vereceğimiz key'in karşılığındaki
    value'yu alip test method'una dondurur

     */

    static Properties properties; //configuration.properties'deki tum key-valueler yuklendi

    static { //static blok herseyden önce calisir

        String dosyaYolu="configuration.properties";



        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fis);
        } catch (Exception e) {

            System.out.println("properties dosyasi okunamadi");
        }




    } //static blok herseyden önce calisir ve configuration.properties dosyasındaki
    // key value ikililerini properties objesine yukler

  public static String getProperty(String key){

        return properties.getProperty(key);
  }



}
