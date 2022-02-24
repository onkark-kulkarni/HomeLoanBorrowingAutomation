package wipro.HomeLoanBorrowing.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static Driver _driver=null;
	WebDriver driver;
	
	
	private Driver(String browserName)  {
		
		if(browserName.equalsIgnoreCase("chrome")) {		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
	}
	
	public static Driver getDiverInstance() {
		if(_driver==null) {
			_driver=new Driver("chrome");
		}
		return _driver;
	}
	
	public WebDriver getDriver() {
		return driver;
		
	}
	public void closeBrowser() {
		driver.close();
	}
}
