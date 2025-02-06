package ananthuProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.cache.AbstractCache;

import ananthuProject.AbstractComponent.AbstractComponent;

public class SelectedBookPage extends AbstractComponent {
	
	ChromeDriver driver;


	public SelectedBookPage(ChromeDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//button[@aria-label='Add to cart. Product is Golden: The Power of Silence in a World of Noise']//span[@class='MuiButton-label'][normalize-space()='Add to Cart']")
	WebElement addToCart;
	
	By bookTitleVisibility=By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1']");
			
	
	public ShoppingCartPage addToCart() {
		
		waitForElementToAppear(bookTitleVisibility);
		addToCart.click();
		
		ShoppingCartPage shoppingCet= new ShoppingCartPage(driver);
		return shoppingCet;
		
	}
	

}
