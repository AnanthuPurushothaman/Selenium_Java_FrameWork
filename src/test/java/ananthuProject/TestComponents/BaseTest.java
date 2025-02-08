package ananthuProject.TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ananthuProject.PageObjects.LandingPage;

public class BaseTest {
	
	public ChromeDriver driver;
	public LandingPage landingpage;
	
	public ChromeDriver initilizeDriver() {
		
		driver = new ChromeDriver();
		driver.get("https://bookoutlet.ca/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	@BeforeMethod
	public LandingPage launchApplication(){
		
		driver=initilizeDriver();
		landingpage= new LandingPage(driver);
		landingpage.getBaseUrl();
		return landingpage;
		
	}
	@AfterMethod
	public void closeDriver() {
		
		driver.close();
	}
	public String getScreenshot(String testCaseName, ChromeDriver driver) throws IOException {
	    // Capture the screenshot and store it in a file
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    // Define the destination path for the screenshot
	    String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	    // Copy the screenshot file to the destination
	    FileUtils.copyFile(src, new File(destinationFile));

	    // Return the path of the screenshot
	    return destinationFile;
	}


}
