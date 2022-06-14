package scripts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedAirlinesHomePage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    SoftAssert softAssert;
    //creating instance variables
    UnitedAirlinesHomePage unitedAirlinesHomePage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();

        //Initializing page objects
        unitedAirlinesHomePage = new UnitedAirlinesHomePage();
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }

}
