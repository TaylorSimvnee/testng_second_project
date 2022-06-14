package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base{
    /*
    Test Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
    |BOOK                	          	  |
    |MY TRIPS            	          	  |
    |TRAVEL INFO         	  |
    |MILEAGEPLUS® PROGRAM|
    |DEALS               	          	  |
    |HELP                	          	  |
     */

    @Test(priority = 1, description = "Test Case 1: Validate \"Main menu\" navigation items")
    public void validateMainMenuNavigationItems(){
        driver.get("https://www.united.com/en/us");

        String[] navigationItemsList = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(unitedAirlinesHomePage.mainMenuNavigationList.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesHomePage.mainMenuNavigationList.get(i).getText(), navigationItemsList[i]);
        }
    }
    /*
    Test Case 2: Validate "Book travel menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see "Book travel menu" navigation items
    |Book             |
    |Flight Status|
    |Check-in       |
    |My trips        |

     */

    @Test(priority = 2, description = "Test Case 2: Validate \"Book travel menu\" navigation items")
    public void validateTravelBookMenuNavigationItems(){
        driver.get("https://www.united.com/en/us");

        String[] bookTravelItemsList = {"Book", "Flight status", "Check-in", "My trips"};

        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(unitedAirlinesHomePage.bookTravelMenuList.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesHomePage.bookTravelMenuList.get(i).getText(), bookTravelItemsList[i]);
        }
    }

    /*
    Test Case 3: Validate "Round-trip" and "One-way" radio buttons
    Given user is on "https://www.united.com/en/us"
    Then validate "Roundtrip" radio button is displayed, is enabled and is selected
    And validate "One-way" radio button is displayed, is enabled but is not selected
    When user clicks on "One-way" radio button
    Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
     */

    @Test(priority =3, description = " Test Case 3: Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void testRoundTripAndOneWayRadioButtons(){
        driver.get("https://www.united.com/en/us");

        softAssert.assertTrue(unitedAirlinesHomePage.roundTripRadioButton.isDisplayed());
        softAssert.assertTrue(unitedAirlinesHomePage.roundTripRadioButton.isEnabled());
        softAssert.assertTrue(unitedAirlinesHomePage.roundTripRadioButton.isSelected());

        softAssert.assertTrue(unitedAirlinesHomePage.oneWayRadioButton.isDisplayed());
        softAssert.assertTrue(unitedAirlinesHomePage.oneWayRadioButton.isEnabled());
        softAssert.assertFalse(unitedAirlinesHomePage.oneWayRadioButton.isSelected());

        unitedAirlinesHomePage.oneWayRadioButton.click();
        Waiter.pause(2);

        softAssert.assertTrue(unitedAirlinesHomePage.oneWayRadioButton.isSelected());
        softAssert.assertFalse(unitedAirlinesHomePage.roundTripRadioButton.isSelected());

    }

    /*
    Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
    Given user is on "https://www.united.com/en/us"
    Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
    And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
    When user clicks both checkboxes
    Then validate both checkboxes are selected
    When user clicks on both selected checkboxes again
    Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = "Test Case 4: Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void testBookWithMilesAndFlexibleDatesCheckBoxes(){
        driver.get("https://www.united.com/en/us");

        softAssert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBoxLabel.isDisplayed());
        softAssert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBoxLabel.isEnabled());
        softAssert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBoxLabel.isSelected());

        softAssert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBoxLabel.isDisplayed());
        softAssert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBoxLabel.isEnabled());
        softAssert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBoxLabel.isSelected());

        unitedAirlinesHomePage.bookWithMilesCheckBoxLabel.click();
        unitedAirlinesHomePage.flexibleDatesCheckBoxLabel.click();
    }

    /*
    Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
     */

    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)\"")
    public void testingOneWayTicketSearchResults(){
        driver.get("https://www.united.com/en/us");

        unitedAirlinesHomePage.oneWayRadioButton.click();
        unitedAirlinesHomePage.fromInputBox.clear();
        unitedAirlinesHomePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedAirlinesHomePage.toInputBox.clear();
        unitedAirlinesHomePage.toInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesHomePage.datesInputBox.clear();Waiter.pause(3);
        unitedAirlinesHomePage.datesInputBox.sendKeys("Jan 30");
        unitedAirlinesHomePage.datesInputBox.click();Waiter.pause(3);
        unitedAirlinesHomePage.travelersInput.click();
        unitedAirlinesHomePage.add1MoreAdultButton.click();
        unitedAirlinesHomePage.cabinTypeButton.click();
        unitedAirlinesHomePage.selectCabinType("Business or First");
        unitedAirlinesHomePage.findFlightsButton.click();

        Assert.assertTrue(unitedAirlinesHomePage.departureHeading.isDisplayed());
        Assert.assertEquals(unitedAirlinesHomePage.departureHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");
    }

}
