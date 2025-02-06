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
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-content-xs-flex-start']//div//h6[@class='MuiTypography-root jss3219 MuiTypography-subtitle1 MuiTypography-gutterBottom']")
	List<WebElement> bookNameInCart;
	
	public void goToCart(){
		
		goToShoppingCart.click();
		
	  	//bookNameInCart.stream().forEach(q->System.out.println(q.getText()));
		System.out.println(bookNameInCart.size());
	}
}
//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-content-xs-flex-start']//div//h6[@class='MuiTypography-root jss3219 MuiTypography-subtitle1 MuiTypography-gutterBottom']