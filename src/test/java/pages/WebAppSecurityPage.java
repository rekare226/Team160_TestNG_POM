package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebAppSecurityPage {

    public WebAppSecurityPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='homeMenu']")
    public WebElement homeSayfa;

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement anasayfaSignButonu;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement loginKutusu;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signInButonu;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[1]")
    public WebElement settingsMenu;

    @FindBy(xpath = "//*[@id='onlineBankingMenu']")
    public WebElement onlineBankingButton;

    @FindBy(xpath = "//*[@id='pay_bills_link']")
    public WebElement payBillsPage;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeign;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public WebElement currencyMenu;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public WebElement euroZone;

}
