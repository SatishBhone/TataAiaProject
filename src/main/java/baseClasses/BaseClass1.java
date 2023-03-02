package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1 {
	
	public static WebDriver getDriver(String browser) 
	{    WebDriver driver = null;
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\satis\\Driver\\chromedriver_win32\\chromedriver.exe");

		        driver = new ChromeDriver();
		} else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.gecko.driver", "/aiatata/src/main/resources/Browsers/msedgedriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.get("https://www.tataaia.com/");
		driver.manage().window().maximize();
		return driver;
		
	} 

}
