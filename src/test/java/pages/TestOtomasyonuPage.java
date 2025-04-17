package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@*='prod-img']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "(//*[@class=' heading-sm mb-4'])")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//span[@class='menu-icon-text'])[1]")
    public WebElement accountButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement testotomasyonuEmail;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement testotomasyonuPassWord;

    @FindBy(xpath = "//*[@id='submitlogin']")
    public WebElement testotomasyonuSignButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement tesotomasyouLogoutYazisi;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addtoCardButonu;


    @FindBy(xpath = "(//span[.='Your Cart'])[1]")
    public WebElement yourCardButonu;

    @FindBy(xpath = "//*[@class='product-title text-center']")
    public WebElement sepettekiUrunElementi;

    @FindBy(xpath = "//*[@class='product-count-text']")
    public WebElement aramaSonucuUrunSayisiElementi;

}
