package Page;

import driver.Driver;
import driver.DriverFactory;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationWebPage {
    public AutomationWebPage(){
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@value='Male']")
    public WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@value='FeMale']")
    public WebElement genderFeMaleRadio;

    @FindBy(xpath = "//div[@id='msdd']")
    public WebElement languagesBox;

    @FindBy(xpath = "//*[@id=\"Skills\"]")
    public WebElement skillsBox;

    @FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a")
    public List<WebElement> items;

    @FindBy(xpath ="//*[@id='Skills']/option" )
    public List<WebElement> skillsAll;

    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    public WebElement countryArrow;

    @FindBy(xpath = "//select[@class='select2-hidden-accessible']")
    public WebElement  countryDropDown;

    @FindBy(xpath ="//select[@id='yearbox']" )
    public WebElement yearBoxButton;

    @FindBy(xpath = "//select[@id='yearbox']/option" )
    public List<WebElement> yearBox;

    @FindBy(xpath ="//select[@ng-model='monthbox']" )
    public WebElement monthBoxButton;

    @FindBy(xpath = "//select[@ng-model='monthbox']/option" )
    public List<WebElement> monthBox;

    @FindBy(xpath = "//select[@ng-model='daybox']")
    public WebElement dayBoxButton;

    @FindBy(xpath = "//select[@ng-model='daybox']/option")
    public List<WebElement> dayBox;

    @FindBy(xpath = "//input[@id='firstpassword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='secondpassword']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//button[@id='submitbtn']")
    public WebElement submitButton;



}
