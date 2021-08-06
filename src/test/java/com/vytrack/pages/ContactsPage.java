package com.vytrack.pages;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

    //since we are extending BasePage we don't need to create a constructor again for this page

    @FindBy(css=".input-widget")
    public WebElement pageNumber;
    @FindBy(xpath = "//table//tbody//tr[4]/td[4]")
    public WebElement email;
    @FindBy(xpath = "//*[@class='user-name']")
    public WebElement fullName;
    @FindBy(xpath = "//*[@title='mbrackstone9@example.com']")
    public  WebElement emailMariam;
    @FindBy(xpath = "//*[@title='+18982323434']")
    public WebElement phoneNumber;

    //this is the locater found for Jamal for email
    //it is better than index since it not change probably and even we applied 2 conditions
    @FindBy (xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement getContactEmail;

    //method for make dynimic the email element
    public WebElement getContactEmail(String getEmail){
       String xpath = xpath = "//td[contains(text(),'" + getEmail + "')][@data-column-label='Email']";
       return Driver.get().findElement((By.xpath(xpath)));
    }
}
