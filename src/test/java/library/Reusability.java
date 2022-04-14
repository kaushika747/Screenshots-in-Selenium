package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Reusability {
	public static void capturedScreenShot(WebDriver driver, String screensShotName) {
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" + screensShotName + ".png"));
			System.out.println("Captured Screenshot - By Selenium WebDriver");
		}
		catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
			
		}
	}

}
