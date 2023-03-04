package testClasses;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClasses.BaseClass1;

import pomClasses.HomePage;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;


public class TestNgClass {
	
  WebDriver driver;
  HomePage hp;
  ExtentHtmlReporter htmlReporter;
  ExtentReports report;
  ExtentTest test;
   @Parameters("browser")
	@BeforeClass
	  public void beforeClass(String bName) 
	{
	   htmlReporter = new ExtentHtmlReporter("tataaia-testOutput.html");
	   report = new ExtentReports();
	   report.attachReporter(htmlReporter);
	   test = report.createTest("VerifyBrowserisLaunchSuccessfully");
	   
		driver = BaseClass1.getDriver(bName);
		
	  }

  @BeforeMethod
  public void beforeMethod() 
  {
	 hp = new HomePage(driver);
  }
  

  @Test
  public void VerifyBrowserisLaunchSuccessfully() 
  {
	  hp.scrolltoElement(driver);
	  hp.putFullName();
	  hp.putMobNum();	  
	  hp.selectPlan();
	  hp.clickOnGetcallBtn();
  }
  
  @AfterMethod
  public void afterMethod()
  {   
	  // Verify submission success message
     WebElement succMessage = driver.findElement(By.xpath("//div[@Class='popup-title-wrap popup-new-title-wrap']//h2"));
     if(succMessage.getText().contains("Success")) 
     {
    	 test.log(Status.PASS, "Lead Form Submit Successfully");
     }
     else 
     {
    	 test.log(Status.FAIL, "Lead Form Not Submit Successfully");
     }
      
  }

  
  @AfterClass
  public void afterClass() 
  {    // Close browser and flush Extent Report
	  
	  driver.quit();
	  report.flush();
	  
  }

}
