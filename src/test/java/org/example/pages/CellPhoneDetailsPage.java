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

public class CellPhoneDetailsPage {
    ExtentTest test;
    public CellPhoneDetailsPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath = "//button[@id='add-to-cart-button-19']")
    WebElement addtocart;
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingcart;


    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(addtocart.isDisplayed());
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

    public void ADDTOCART() throws IOException {

        try {
            test.info("Click add to cart");
            if (addtocart.isDisplayed()) {
                addtocart.click();
                Thread.sleep(2000);
                passCaseWithSC("add to cart selected", "add to cart select successful");

                try{
                    Actions actions = new Actions(PageDriver.getCurrentDriver());
                    test.info("Click shoppingcart");
                    if (shoppingcart.isDisplayed()){
                        actions.moveToElement(shoppingcart).build().perform();
                        shoppingcart.click();
                        Thread.sleep(5000);
                        passCaseWithSC("shoppingcart selected","shoppingcart select successful");
                    }

                } catch (Exception e){
                    failCase("shoppingcart is not locatable", "shoppingcartselectfail");
                }
            }

        } catch (Exception e) {
            failCase("add to cart is not locatable", "addtocartselectfail");
        }




    }



}
