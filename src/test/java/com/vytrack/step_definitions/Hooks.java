package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {


    @Before
    public void setUp() throws InterruptedException {

    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ( (TakesScreenshot)Driver.get() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
         }

        Driver.closeDriver();
    }
  /*  @Before("@db")
    public void setUpdb(){
        System.out.println("DataBase conection in BEFORE method");
    }
    @After("@db")
    public void tearDowndb(){
        System.out.println("DataBAse conection in AFTER method");

    }*/
}
