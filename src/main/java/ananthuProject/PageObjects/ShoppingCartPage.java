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
	
	@FindBy(css="a[aria-label='proceed to checkout']")
			WebElement checkOut;
	
	public void goToCart(){
		
		goToShoppingCart.click();
		
	  
	}
	
	public void proceedToCheckOut() {
		checkOut.click();
	}
}
