package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.baseDriver.PageDriver;
import org.example.utilities.GetScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class ShippingPage {
    ExtentTest test;
    public ShippingPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath = "//input[@id='shippingoption_1']")
    WebElement nextdayair;
    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    WebElement continu;

    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(nextdayair.isDisplayed());
        PageDriver.getCurrentDriver().quit();
    }

    public void passCase(String message){
        test.pass("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
    }

    @SuppressWarnings("unused")
    public void passCaseWithSC(String message, String scName) throws IOException {
        test.pass("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }

    public void SHIPPING() throws IOException {
        try {
            Actions actions = new Actions(PageDriver.getCurrentDriver());
            test.info("click nextday air button");
            if (nextdayair.isDisplayed()) {
                actions.moveToElement(nextdayair).build().perform();
                nextdayair.click();
                Thread.sleep(5000);
                passCaseWithSC("clicked nextdayair", "clicked nextdayair successful");

                try {
                    test.info("Click continuebutton");
                    if (continu.isDisplayed()) {
                        continu.click();
                        Thread.sleep(5000);
                        passCaseWithSC("clicked continue", "clicked continue successful");

                    }
                } catch (Exception e) {
                    failCase("unable to locate continue", "continuefail");
                }
            }

        } catch (Exception e) {
            failCase("Unable to locate nextdayairbutton", "nextdayairfail");
        }

    }

}
