package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.baseDriver.BaseDriver;
import org.example.pages.CellPhoneDetailsPage;
import org.example.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CellPhoneDetailsPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start(){
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Cellphone details Page</b></p>");
    }

    @Test
    public void addTOcart() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CellphoneDetailsPage TEST</b></p>");
        CellPhoneDetailsPage cellPhoneDetailsPage = new CellPhoneDetailsPage(childTest);
        cellPhoneDetailsPage.ADDTOCART();
    }
    @AfterClass
    public void report(){
        report.flush();
    }

}
