package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.baseDriver.PageDriver;
import org.example.utilities.GetScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class PaymentInformationPage {
    ExtentTest test;
    public PaymentInformationPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath = "//input[@id='CardholderName']")
    WebElement cName;
    @FindBy(xpath = "//input[@id='CardNumber']")
    WebElement cardNumber;
    @FindBy(xpath = "//select[@id='ExpireMonth']")
    WebElement Emonth;
    @FindBy(xpath = "//select[@id='ExpireYear']")
    WebElement Eyear;
    @FindBy(xpath = "//input[@id='CardCode']")
    WebElement cardcode;
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement continu;

    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(cName.isDisplayed());
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

    public void paymentcard() throws IOException {
        try {
            test.info("Cardholder name");
            if (cName.isDisplayed()) {
                cName.sendKeys("asik");
                Thread.sleep(5000);
                passCaseWithSC("Cardholdername sent", "cardholderName successful");
                try {
                    test.info("Card Number");
                    if (cardNumber.isDisplayed()) {
                        cardNumber.sendKeys("4242424242424242");
                        Thread.sleep(5000);
                        passCaseWithSC("cardnumber set", "set cardnumber successful");

                        try {
                            Select select = new Select(Emonth);
                            test.info("Expiry month");
                            if (Emonth.isDisplayed()) {
                                select.selectByIndex(4);
                                Thread.sleep(5000);
                                passCaseWithSC("ExpiryMonth set", "set expiry month successful");

                                try {
                                    Select select1 = new Select(Eyear);
                                    test.info("Expiry year");
                                    if (Eyear.isDisplayed()) {
                                        select1.selectByIndex(4);
                                        Thread.sleep(5000);
                                        passCaseWithSC("ExpiryYear set", "set expiry Year successful");

                                        try {
                                            test.info("Card Code");
                                            if (cardcode.isDisplayed()) {
                                                cardcode.sendKeys("145");
                                                Thread.sleep(5000);
                                                passCaseWithSC("cardcode set", "set cardcode successful");

                                                try {
                                                    test.info("Click continue");
                                                    if (continu.isDisplayed()) {
                                                        continu.click();
                                                        Thread.sleep(5000);
                                                        passCaseWithSC("clicked continue", "continue click successful");
                                                    }

                                                } catch (Exception e) {
                                                    failCase("continue is not locatable", "continuefail");
                                                }

                                            }
                                        } catch (Exception e) {
                                            failCase("unable to locate cardcode", "cardcodefail");
                                        }
                                    }
                                } catch (Exception e) {
                                    failCase("unable to locate eYear", "eYear");
                                }
                            }
                        } catch (Exception e) {
                            failCase("unable to locate eMonth", "eMonthfail");
                        }


                    }
                } catch (Exception e) {
                    failCase("unable to locate cardnumber", "cardnumberfail");
                }
            }

        } catch (Exception e) {
            failCase("Unable to locate cardholder", "cardholderfail");
        }


    }


}
