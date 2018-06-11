package util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
protected WebDriver driver;
	
	@BeforeTest
	public void openUrl() {
		String abPath= System.getProperty("user.dir") ;
		String setChromePath =abPath + "\\src\\main\\java\\com\\myntra\\util\\chromedriver.exe" ; 
//		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", setChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.myntra.com");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}


}
