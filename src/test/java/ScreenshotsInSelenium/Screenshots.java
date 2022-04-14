package ScreenshotsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import library.Reusability;

public class Screenshots {
	WebDriver driver;
	
	@Test
	public void TestLocator() {
		System.setProperty("webdriver.chrome.driver", 
				"D:\\DXC Selenium Automation Testing\\ScreenshotsInSelenium\\ChromeJar\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtusername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword123")).sendKeys("admin123");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Reusability.capturedScreenShot(driver, result.getName());
		}
		driver.quit();
	}

}
