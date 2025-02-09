package ananthuProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import ananthuProject.AbstractComponent.AbstractComponent;

public class ShoppingCartPage extends AbstractComponent {

	ChromeDriver driver;
	
	public ShoppingCartPage(ChromeDriver driver) {
		super(driver);
        this.driver=driver;
	}

	@FindBy(xpath="//*[name()='path' and contains(@d,'M15.55 13c')]")
	WebElement goToShoppingCart;
	
	
	public void goToCart(){
		
		goToShoppingCart.click();
		
	  
	}
	
	public String getPageTitle() {
	  String pageTitle= driver.getTitle();
	   return pageTitle;
	}
}
