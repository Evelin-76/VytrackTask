package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationStepDef {
    @Given("the user is in the web page")
    public void theUserIsInTheWebPage() {
        System.out.println("Users is on the login page");
    }

    @And("the user enter the manager information")
    public void theUserEnterTheManagerInformation() {
        System.out.println("enter manager information");
    }

    @When("user navigate Fleet,Vehicle")
    public void userNavigateFleetVehicle() {
        System.out.println("User navigate to Fleet / Vehicle");
    }

    @Then("the title should be Vehicle")
    public void theTitleShouldBeVehicle() {
        System.out.println("Vehicle is the title page");
    }

    @When("user navigates to Marketing,Campaings")
    public void userNavigatesToMarketingCampaings() {
        System.out.println("User navigates to Marketing / Campaign");
    }

    @Then("the title should be Campaigns")
    public void theTitleShouldBeCampaigns() {
        System.out.println("Campaigns is the title page");
    }

    @When("user navigates to Activities,Calendar Events")
    public void userNavigatesToActivitiesCalendarEvents() {
        System.out.println("User navigates to Activities / Calendar Events");
    }

    @Then("the title should be Calendars")
    public void theTitleShouldBeCalendars() {

        System.out.println("Calendars is the title of the page");
    }
    @When("navigate to {string} {string}")
    public void navigateTo(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
    }
    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(5);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber =Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNum,actualNumber);
    }

}
