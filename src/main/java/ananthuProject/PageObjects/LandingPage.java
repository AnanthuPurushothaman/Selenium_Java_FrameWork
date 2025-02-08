package ananthuProject.PageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	ChromeDriver driver;
	
	public LandingPage(ChromeDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

@FindBy(xpath="//div[@class='builder-block builder-c6601fee21084f328cdc18cda136157b css-g9l40v']/div/div/a")	
List<WebElement> myListFooter;	

@FindBy(xpath="//div[@class='builder-block builder-f8b946096eab42efb0b044803f869be2 builder-has-component css-at3cpz builder-symbol']//span[@class='builder-text css-1qggkls']//span[1]")
WebElement bannernoticeText;




	public void getBaseUrl() {
		
		driver.get("https://bookoutlet.ca/");
	}

	public String getLandingPageTitle() {
	   String basePgeTitle=	driver.getTitle();
	   return basePgeTitle;
	}
	
	public void getFooterTitle() throws InterruptedException {
		
		for(int i=0;i<myListFooter.size();i++) {
			
			String ctrlEnter=Keys.chord(Keys.CONTROL,Keys.ENTER);
			myListFooter.get(i).sendKeys(ctrlEnter);
		}
		
		Set<String>window = driver.getWindowHandles();
		Iterator<String>it=window.iterator();
		String mainWindow =it.next();
	
		
		List<String>titleList = new <String>ArrayList();
		while(it.hasNext()) {
			
			
			WebDriver pageTitle=driver.switchTo().window(it.next());
			titleList.add(pageTitle.getTitle());
			
		}
		titleList.stream().forEach(b->System.out.println(b));
		driver.switchTo().window(mainWindow);
		driver.close();
		
	}
	
	public boolean checkVisibilityOfPromoText() {
		
		if(bannernoticeText.isDisplayed()) {
			
			return true;
		}
		else {
			
			return false;
		}
		
		
	}

	
	

}
