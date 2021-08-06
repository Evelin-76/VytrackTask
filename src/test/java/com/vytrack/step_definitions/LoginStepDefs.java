package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enter the drver information")
    public void the_user_enter_the_drver_information() {

       // String username = ConfigurationReader.get("driver_username");
       // String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
    }

    @Then("the user should me able to login")
    public void the_user_should_me_able_to_login() {
        BrowserUtils.waitFor(1);
        String actualTitle = Driver.get().getTitle();
        System.out.println(actualTitle);
        //Assert.assertEquals("Dashboard",actualTitle);
    }


    @When("the user enter the manager information \\(create a step definition for manager due it is not same in scenario)")
    public void loginAsSaleManager() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSaleManager();
    }

    @When("the user enter the store manager information")
    public void theUserEnterTheStoreManager() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
    }

    @When("the user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
        System.out.println("username is " + username);
        System.out.println("password is " + password);
    }

    @And("the title contains {string}")
    public void theTitleContains(String title) {
        BrowserUtils.waitFor(3);
        System.out.println(Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().contains(title));

    }

    @When("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {
            String username;
            String password;

            switch (userType.toLowerCase().replace(" ","")) {
                case "driver": new LoginPage().loginAsDriver(); break;
                case "salesmanager": new LoginPage().loginAsSaleManager(); break;
                case "storemanager": new LoginPage().loginAsStoreManager(); break;
            }
            System.out.println(userType);//to know what user type is selected in feature file
    }

}
