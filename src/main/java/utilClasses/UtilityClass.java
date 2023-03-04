package utilClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

   //Scrolling Method // TakeScreenshot Method // Read Excel file// 
	public static String getScreenShot(WebDriver driver, String testName) throws IOException
	{
		Date date = new Date();
		
		SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		
		String currentDate = f.format(date);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path = testName+".png";
		
		File dest = new File(path);
		
		FileHandler.copy(source, dest);
		
		return path;
		}
	
	public void scrolltoElement(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement fullname = driver.findElement(By.xpath("//input[@id='createLeadneedformfullname']"));
		js.executeScript("arguments[0].scrollIntoView(true)", fullname);
	
	
	}
}
