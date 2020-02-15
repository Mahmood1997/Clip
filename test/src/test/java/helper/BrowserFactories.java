package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactories {
	
	 static WebDriver driver;
		public static WebDriver startBrowser(String browsername, String urls)
		{
			//WebDriver driver = null;
			if(browsername.equalsIgnoreCase("firefox"))
			{
				driver= new FirefoxDriver();
			}
			
			else if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (browsername.equalsIgnoreCase("IE"))
			{
				driver= new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(urls);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		}
		
	

}
