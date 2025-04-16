package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//input[@id='email']")
public WebElement facebookEmail;

@FindBy(xpath = "//input[@id='pass']")
 public WebElement facebookPassword;

@FindBy(xpath= "//button[@type='submit']")
public WebElement facebookgirisButonu;
}
