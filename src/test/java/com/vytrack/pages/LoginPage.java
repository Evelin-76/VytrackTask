package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {//WE CREATE HERE THE WAIT TO MANAGE, UPDATE AND MAINTAINED
    // OUR LOCATORS IF NECESSARY

    public LoginPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    //use driver.findElement(By.locaterType("locator")
    // i.e. ->driver.findElemnt(By.id("prependedInput")

    //1.This way looks for all locators and if one of the match it will return it. || OR logic operator is immplemented here
  //  @FindAll({
  //          @FindBy(id = "prependedInput"),
  //          @FindBy(id = "prependedInput2"),
  //  })

    //2.This way look for locators and if they match with element then it will return it.& AND logic op. applies here
  //  @FindBys({
  //          @FindBy(id = "prependedInput"),
  //          @FindBy(id = "prependedInput2"),
  //  })



    //3.This way look locators one by one even if we have a list of elements we can use it
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy (id = "_submit")
    public WebElement loginButton;

    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void loginAsStoreManager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void loginAsSaleManager(){
        String username = ConfigurationReader.get("salemanager_username");
        String password = ConfigurationReader.get("salemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
