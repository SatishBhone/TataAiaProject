package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import baseClasses.BaseClass1;
import pomClasses.HomePage;

public class VerifyUserRegisterSuccessfully {
    WebDriver driver;
    
    ExtentHtmlReporter htmlReport;
	ExtentReports report;
	ExtentTest test;

	HomePage hp;
	@Parameters("browser")
	@BeforeClass()
	public void beforeclass(String bName) 
	{
         htmlReport = new ExtentHtmlReporter("TataAIA.html");
		 report = new ExtentReports();
		report.attachReporter(htmlReport);
		 test = report.createTest("Test1");
		
		 driver =BaseClass1.getDriver(bName);
		
	}
	
	@BeforeMethod()
	public void beforeMethod() 
	{
		hp = new HomePage(driver);
	}
	
	@Test
	public void Test1() 
	{
		hp.putFullName();
		hp.putMobNum();
		hp.scrolltoElement(driver);
		hp.selectPlan();
		hp.clickOnGetcallBtn();
		
	}
	
	@AfterMethod()
	public void afterMethod(ITestResult Result) throws IOException 
	{ // Verification and validation code is here
		if(Result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "Test is pass"+ Result.getName());
		}else 
		{
			String path =  hp.getScreenShot(driver, Result.getName());
			test.log(Status.FAIL, "Test is fail"+ Result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());   
		}
		
	}
	@AfterClass()
	public void afterClass()
	{
		driver.close();
	    report.flush();
	}
}

