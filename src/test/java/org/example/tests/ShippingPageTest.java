package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.baseDriver.BaseDriver;
import org.example.pages.CartPage;
import org.example.pages.ShippingPage;
import org.example.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ShippingPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start(){
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Shipping Page</b></p>");
    }
    @Test
    public void cartTest() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>ShippingPage TEST</b></p>");
        ShippingPage shippingPage = new ShippingPage(childTest);
        shippingPage.SHIPPING();
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
