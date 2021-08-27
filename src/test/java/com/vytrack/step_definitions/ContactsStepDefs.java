package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Given("the user logged in as a {string}")
    public void the_user_logged_in_as_a(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));

        //base on input enter that user information
        String username = null;
        String password = null;

        if(userType.equals("driver")){
            username = ConfigurationReader.get(("driver_username"));
            password = ConfigurationReader.get("driver_password");
        }else if( userType.equals("sales manager")){
            username = ConfigurationReader.get(("sales_anager_username"));
            password = ConfigurationReader.get("salesmanager_password");
        }else if( userType.equals("store manager")) {
            username = ConfigurationReader.get(("storemanager_username"));
            password = ConfigurationReader.get("storemanager_password");
        }
        //send username and password and login
        new LoginPage().login(username,password);
    }
    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
       BrowserUtils.waitForPageToLoad(5);
        //get the list on web elements locator in basePage and assert
       // List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

       // System.out.println("11"  + actualOptions);
        System.out.println("Dime el texto"+Driver.get().findElement(By.xpath("(//*[@class='title title-level-1'])[1]")).getText());

        List<WebElement> acEL = new DashboardPage().menuOptions;
        List<String> saveEl = new ArrayList<>();
        for(WebElement each : acEL ){
            saveEl.add(each.getAttribute(""));
        }

        System.out.println("menu options: " + menuOptions);
        System.out.println("actual options: " + saveEl);

        Assert.assertEquals(menuOptions,saveEl);


    }

    @When("the user logs in using following credentials")
    public void theUserLogsInUsingFollowingCredentials(Map<String,String> userInfo) {
        System.out.println(userInfo);

        //use map information to login and also verify first and last name:
        //login with map info
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        //verify first and last  name
        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname") + " " + userInfo.get("lastname");

        Assert.assertEquals(expectedName,actualName);
        System.out.println(expectedName);
        System.out.println(actualName);
    }

    @And("user navigate to {string} {string}")
    public void userNavigateTo(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
    }

    @When("the user clicks the {string} from contacts")
    public void theUserClicksTheFromContacts(String email) {
        BrowserUtils.waitFor(5);
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail(email).click();
    }

    @Then("the information should be same with database")
    public void theInformationShouldBeSameWithDatabase() {
        BrowserUtils.waitFor(3);
        //get info from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualfullName = contactInfoPage.fullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhoneNumber = contactInfoPage.phoneNumber.getText();

        System.out.println("Actual full name " + actualfullName);
        System.out.println("Actual phone " + actualPhoneNumber);
        System.out.println("Actual email " + actualEmail);

        //get info from DB:
        //getting one row (copied and pasted from MySQL query)
        String query =
                "SELECT CONCAT(FIRST_NAME,' ',LAST_NAME) AS \"full name\", E.EMAIL, PHONE " +
                "FROM OROCRM_CONTACT C "+
                "JOIN OROCRM_CONTACT_EMAIL E "+
                "ON C.ID = E.OWNER_ID "+
                "JOIN OROCRM_CONTACT_PHONE P "+
                "ON C.ID = P.OWNER_ID "+
                "WHERE E.EMAIL = 'mbrackstone9@example.com'";

        Map<String,Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullName = (String) rowMap.get("full name");
        String expectedPhone = (String) rowMap.get("phone");
        String expectedEmail = (String) rowMap.get("email");
        System.out.println("Expected full name " + expectedFullName);
        System.out.println("Expected phone " + expectedPhone);
        System.out.println("Expected email " + expectedEmail);

        //assertion
        Assert.assertEquals(actualfullName,expectedFullName);
        Assert.assertEquals(actualEmail,expectedEmail);
        Assert.assertEquals(actualPhoneNumber,expectedPhone);



    }
}
