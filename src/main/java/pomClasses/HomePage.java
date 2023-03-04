package pomClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilClasses.UtilityClass;

public class HomePage extends UtilityClass{
	
	WebDriver driver;
	@FindBy(xpath="//input[@id='createLeadneedformfullname']")
	private WebElement fullname;
   

	@FindBy(xpath="//input[@id='createLeadneedformmobileNo']")
	private WebElement MobNumbr;
	
	@FindBy(xpath="//div[@class='selectBox']")  //Box
	private WebElement selectplan;
	
	@FindBy(xpath="//button[@id='getCallBacksbtnabc']") //abc
	private WebElement getCallbackBtn;
	
     public HomePage(WebDriver driver) 
     {
    	 PageFactory.initElements(driver, this);
    	 this.driver = driver; 
     }
     
     public void putFullName() 
     {
    	 fullname.sendKeys("Shrikant");
     } 
     
     public void putMobNum() 
     {
    	 MobNumbr.sendKeys("6746435464");
     } 
     
     public void selectPlan() 
     {
    	WebElement drop=driver.findElement(By.xpath("//span[@role='textbox' and @id='select2-selectValue-container']"));
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript("arguments[0].scrollIntoView(true)", drop);
    	WebElement dropdown = driver.findElement(By.xpath("//select[@name='cars']"));
    	 Select sec = new Select(dropdown);
    	 sec.selectByValue("Saving Plans");
    	 
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 
     }
     
     public void clickOnGetcallBtn() 
     {
    	 getCallbackBtn.click();
     }
}
