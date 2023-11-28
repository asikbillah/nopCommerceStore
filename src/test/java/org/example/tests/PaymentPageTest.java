package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.baseDriver.BaseDriver;
import org.example.pages.PaymentPage;
import org.example.pages.ShippingPage;
import org.example.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentPageTest extends BaseDriver {

    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start(){
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Payment Page</b></p>");
    }

    @Test
    public void PaymentTest() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>PaymentPage TEST</b></p>");
        PaymentPage paymentPage = new PaymentPage(childTest);
        paymentPage.PAYMENT();

    }
    @AfterClass
    public void report(){
        report.flush();
    }

}
