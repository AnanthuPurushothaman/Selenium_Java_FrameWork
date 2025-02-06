package ananthuProject.AbstractComponent;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

		
		ChromeDriver driver;
		
	public AbstractComponent(ChromeDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//div[@class='builder-column css-j5egeq']/div/div/button")	
	List<WebElement> mainCategoryList;
		
	public  void selectMainCategory(String MainCatName) {
		
		WebElement selectMainCategory=	mainCategoryList.stream().filter(b->b.getText().equals(MainCatName)).findFirst().orElse(null);
		selectMainCategory.click();
	}


	

}
