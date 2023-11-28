package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.baseDriver.BaseDriver;
import org.example.baseDriver.PageDriver;
import org.example.utilities.GetScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BaseDriver {
    ExtentTest test;

    public HomePage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath ="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronics;

    @FindBy(xpath ="//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
    WebElement cellphone;

    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(electronics.isDisplayed());
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

    public void HOMEPAGE() throws IOException {
        Actions actions = new Actions(PageDriver.getCurrentDriver());
        try {
            test.info("Go to electronics menu");
            if (electronics.isDisplayed()) {
                actions.moveToElement(electronics).build().perform();
                Thread.sleep(3000);
                cellphone.click();
                Thread.sleep(5000);
                passCaseWithSC("selected", "authorPass");
                }
            } catch (Exception e) {
            failCase("Electronics is not locatable", "electronicsfail");
         }

    }
}
