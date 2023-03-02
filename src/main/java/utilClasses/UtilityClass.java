package utilClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityClass {

	
	public void scrolltoElement(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement fullname = driver.findElement(By.xpath("//input[@id='createLeadneedformfullname']"));
		js.executeScript("arguments[0].scrollIntoView(true)", fullname);
	
	
	}
}
