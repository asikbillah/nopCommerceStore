package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.baseDriver.BaseDriver;
import org.example.pages.CartPage;
import org.example.pages.CheckoutGuestPage;
import org.example.pages.CheckoutPage;
import org.example.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start(){
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Checkout Page</b></p>");
    }

    @Test
    public void checkoutTests() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CheckoutPage TEST</b></p>");
        CheckoutPage checkoutPage = new CheckoutPage(childTest);
        checkoutPage.checkoutTest();
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
