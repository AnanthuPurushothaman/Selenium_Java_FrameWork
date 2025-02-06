package ananthuProject.AbstractComponent;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

		
		ChromeDriver driver;
		
	public AbstractComponent(ChromeDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//div[@class='builder-column css-j5egeq']/div/div/button")	
	List<WebElement> mainCategoryList;
	
	@FindBy(xpath="//div[@class='needsclick  kl-private-reset-css-Xuajs1']/form")
	WebElement brochure;
	
	By brochureCheck=By.xpath("//div[@class='needsclick  kl-private-reset-css-Xuajs1']/form");
	
	@FindBy(xpath="//*[name()='circle' and contains(@cx,'10')]")
	WebElement closeBrochure;
	
		
	public  void selectMainCategory(String MainCatName) {
		
		WebElement selectMainCategory=	mainCategoryList.stream().filter(b->b.getText().equals(MainCatName)).findFirst().orElse(null);
		selectMainCategory.click();
	}
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	



	

}
