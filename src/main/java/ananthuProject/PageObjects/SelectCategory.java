package ananthuProject.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import ananthuProject.AbstractComponent.AbstractComponent;

public class SelectCategory extends AbstractComponent {

	ChromeDriver driver;

	public SelectCategory(ChromeDriver driver) {

		super(driver);
		this.driver = driver;

	}

	@FindBy(xpath = "//div[@class='builder-blocks css-h47494']/div/a")
	List<WebElement> subCat;
	
	

	public void SelectSubCat(String mainCatName,String subCatName) throws InterruptedException {
		
		//Select Main Category.
		selectMainCategory(mainCatName);
	
	    WebElement selectSubCategory=subCat.stream().filter(q->q.getText().equals(subCatName)).findFirst().orElse(null);
		List<String> subTitleCat = subCat.stream().map(d -> d.getText()).collect(Collectors.toList());

		List<String> subTitleCat2 = subTitleCat.stream().filter(s -> !s.trim().isEmpty()) // Only include non-empty
																							// strings
				.collect(Collectors.toList());

		//subTitleCat2.stream().forEach(y -> System.out.println(y));
		System.out.println(subTitleCat2.size());
		
		selectSubCategory.click();
		
		
		

	}



}
