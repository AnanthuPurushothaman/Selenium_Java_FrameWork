package ananthuProject.TestComponents;

import java.time.Duration;

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

}
