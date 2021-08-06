package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions,actualOptions);

        System.out.println("menu options: " + menuOptions);
        System.out.println("actual options: " + actualOptions);

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
}
