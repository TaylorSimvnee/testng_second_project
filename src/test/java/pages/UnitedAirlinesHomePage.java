package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedAirlinesHomePage {

    //Constructor - takes single driver that I use across the framework
    public UnitedAirlinesHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[role='tablist'] span")
    public List<WebElement> mainMenuNavigationList;

    @FindBy(css = "ul[class*='BookTravel']>li")
    public List<WebElement> bookTravelMenuList;

    @FindBy(css = "label[for='roundtrip']")
    public WebElement roundTripRadioButton;

    @FindBy(css = "label[for='oneway']")
    public WebElement oneWayRadioButton;

    @FindBy(css = "label[for='award']")
    public WebElement bookWithMilesCheckBoxLabel;

    @FindBy(id = "flexDatesLabel")
    public WebElement flexibleDatesCheckBoxLabel;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement datesInputBox;

    @FindBy(css = "button[class*='PassengerSelector']")
    public WebElement travelersInput;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement add1MoreAdultButton;

    @FindBy(id = "cabinType")
    public WebElement cabinTypeButton;

//    @FindBy(id = "cabinType_item-2") NOT DYNAMIC
//    public WebElement businessOrFirstListOption;

    @FindBy(css = "li[id^='cabinType_item']") // or through parent -> ul[aria-labelledby='cabinDescriptor']>li
    public List<WebElement> cabinDropdownList;

    @FindBy(css = "button[class*='findFlightBtn']")
    public WebElement findFlightsButton;

    @FindBy(xpath = "//h2")
    public WebElement departureHeading;


    public void selectCabinType(String cabinType){
        for (WebElement type : cabinDropdownList){
            if (type.getText().equals(cabinType)){
                type.click();
                break;
            }
        }
    }




}
