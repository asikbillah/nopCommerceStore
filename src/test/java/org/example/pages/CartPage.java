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

public class CartPage {
    ExtentTest test;
    public CartPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath = "//*[@id=\"termsofservice\"]")
    WebElement termsofservice;
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout;

    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(termsofservice.isDisplayed());
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

    public void CART() throws IOException {
        try{
            Actions actions = new Actions(PageDriver.getCurrentDriver());
            test.info("click agree and checkout button");
            if (termsofservice.isDisplayed()){
                actions.moveToElement(termsofservice).build().perform();
                termsofservice.click();
                Thread.sleep(5000);
                passCaseWithSC("clicked termsofservice","clicked termsofservice successful");

                try{
                    test.info("Click checkoutbutton");
                    if (checkout.isDisplayed()){
                        checkout.click();
                        Thread.sleep(5000);
                        passCaseWithSC("clicked checkout","clicked termsofservice successful");

                    }
                } catch (Exception e){
                    failCase("unable to locate checkout","checkoutfail");
                }
            }

        } catch (Exception e){
            failCase("Unable to locate termsofservice","termsofservicefail");
        }

    }

}
