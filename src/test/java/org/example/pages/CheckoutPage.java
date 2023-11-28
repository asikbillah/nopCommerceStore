package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.baseDriver.PageDriver;
import org.example.utilities.GetScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class CheckoutPage {
    ExtentTest test;
    public CheckoutPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath = "//input[@id='BillingNewAddress_FirstName']")
    WebElement firstname;
    @FindBy(xpath = "//input[@id='BillingNewAddress_LastName']")
    WebElement lastname;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Company']")
    WebElement company;
    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    WebElement country;
    @FindBy(xpath = "//select[@id='BillingNewAddress_StateProvinceId']")
    WebElement state;
    @FindBy(xpath = "//input[@id='BillingNewAddress_City']")
    WebElement city;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
    WebElement address1;
    @FindBy(xpath = "//input[@id='BillingNewAddress_Address2']")
    WebElement address2;
    @FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
    WebElement postalcode;
    @FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
    WebElement phone;
    @FindBy(xpath = "//input[@id='BillingNewAddress_FaxNumber']")
    WebElement faxnumber;
    @FindBy(xpath = "//button[@onclick='Billing.save()']")
    WebElement contnu;

    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "/screenshots/" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(firstname.isDisplayed());
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

    public void checkoutTest() throws IOException {
        Actions actions = new Actions(PageDriver.getCurrentDriver());
        try {
            test.info("Checkout firstname");
            if (firstname.isDisplayed()){
                actions.moveToElement(firstname).build().perform();
                firstname.sendKeys("Asik");
                Thread.sleep(5000);
                passCaseWithSC("firstname sent","firstnamepass");

                try {
                    test.info("Checkout lastname");
                    if (lastname.isDisplayed()){
                        actions.moveToElement(lastname).build().perform();
                        lastname.sendKeys("billah");
                        Thread.sleep(5000);
                        passCaseWithSC("lastname sent","lastnamepass");

                        try {
                            test.info("Checkout Email");
                            if (email.isDisplayed()){
                                actions.moveToElement(email).build().perform();
                                email.sendKeys("abc@gmail.com");
                                Thread.sleep(5000);
                                passCaseWithSC("email sent","emailpass");

                                try {
                                    test.info("Checkout company");
                                    if (company.isDisplayed()){
                                        actions.moveToElement(company).build().perform();
                                        company.sendKeys("ABCD");
                                        Thread.sleep(5000);
                                        passCaseWithSC("company sent","companypass");

                                        try {
                                            Select select = new Select(country);
                                            test.info("Checkout country");
                                            if (country.isDisplayed()){
                                                country.click();
                                                select.selectByIndex(1);
                                                Thread.sleep(5000);
                                                passCaseWithSC("company select","companypass");

                                                try {
                                                    Select select1 = new Select(state);
                                                    test.info("Checkout state");
                                                    if (state.isDisplayed()){
                                                        state.click();
                                                        select1.selectByIndex(2);
                                                        Thread.sleep(5000);
                                                        passCaseWithSC("state select","statepass");

                                                        try {
                                                            test.info("Checkout city");
                                                            if (city.isDisplayed()){
                                                                actions.moveToElement(city).build().perform();
                                                                city.sendKeys("new york");
                                                                Thread.sleep(5000);
                                                                passCaseWithSC("city sent","citypass");

                                                                try {
                                                                    test.info("Checkout address1");
                                                                    if (address1.isDisplayed()){
                                                                        actions.moveToElement(address1).build().perform();
                                                                        address1.sendKeys("D/200 NY");
                                                                        Thread.sleep(5000);
                                                                        passCaseWithSC("address1 sent","address1pass");

                                                                        try {
                                                                            test.info("Checkout address2");
                                                                            if (address2.isDisplayed()){
                                                                                actions.moveToElement(address2).build().perform();
                                                                                address2.sendKeys("N/500 ZME");
                                                                                Thread.sleep(5000);
                                                                                passCaseWithSC("address2 sent","address2pass");

                                                                                try {
                                                                                    test.info("Checkout postal code");
                                                                                    if (postalcode.isDisplayed()){
                                                                                        actions.moveToElement(postalcode).build().perform();
                                                                                        postalcode.sendKeys("123");
                                                                                        Thread.sleep(5000);
                                                                                        passCaseWithSC("postalcode sent","postalcodepass");

                                                                                        try {
                                                                                            test.info("Checkout phoneNumber");
                                                                                            if (phone.isDisplayed()){
                                                                                                actions.moveToElement(phone).build().perform();
                                                                                                phone.sendKeys("+8974844");
                                                                                                Thread.sleep(5000);
                                                                                                passCaseWithSC("phone sent","phonepass");

                                                                                                try {
                                                                                                    test.info("Checkout faxnumber");
                                                                                                    if (faxnumber.isDisplayed()){
                                                                                                        actions.moveToElement(faxnumber).build().perform();
                                                                                                        faxnumber.sendKeys("+65465");
                                                                                                        Thread.sleep(5000);
                                                                                                        passCaseWithSC("fax sent","faxpass");

                                                                                                        try {
                                                                                                            test.info("click continue");
                                                                                                            if (contnu.isDisplayed()){
                                                                                                                actions.moveToElement(contnu).build().perform();
                                                                                                                contnu.click();
                                                                                                                Thread.sleep(5000);
                                                                                                                passCaseWithSC("clicked continue","continuepass");
                                                                                                            }
                                                                                                        } catch (Exception e){
                                                                                                            failCase("unable to locate continue","continuefail");
                                                                                                        }

                                                                                                    }
                                                                                                } catch (Exception e){
                                                                                                    failCase("unable to locate fax","faxfail");
                                                                                                }

                                                                                            }
                                                                                        } catch (Exception e){
                                                                                            failCase("unable to locate phone","phonefail");
                                                                                        }

                                                                                    }
                                                                                } catch (Exception e){
                                                                                    failCase("unable to locate postalcode","postalcodefail");
                                                                                }

                                                                            }
                                                                        } catch (Exception e){
                                                                            failCase("unable to locate address2","address2fail");
                                                                        }


                                                                    }
                                                                } catch (Exception e){
                                                                    failCase("unable to locate address1","address1fail");
                                                                }

                                                            }
                                                        } catch (Exception e){
                                                            failCase("unable to locate city","cityfail");
                                                        }
                                                    }

                                                } catch (Exception e){
                                                    failCase("unable to locate state","statefail");

                                                }

                                            }

                                        } catch (Exception e){
                                            failCase("unable to locate company","companyfail");

                                        }

                                    }

                                } catch (Exception e){
                                    failCase("unable to locate company","companyfail");

                                }

                            }

                        } catch (Exception e){
                            failCase("unable to locate email","emailfail");

                        }

                    }

                } catch (Exception e){
                    failCase("unable to locate lastname","lastnamefail");

                }

            }

        } catch (Exception e){
            failCase("unable to locate firstname","firstnamefail");

        }

    }

}
