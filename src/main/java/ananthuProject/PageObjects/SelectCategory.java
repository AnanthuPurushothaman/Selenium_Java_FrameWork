package ananthuProject.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstractComponent;

public class SelectCategory extends AbstractComponent {

	ChromeDriver driver;

	public SelectCategory(ChromeDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='builder-blocks css-h47494']/div/a")
	List<WebElement> subCat;
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/p")
	List<WebElement>listOfBooks;	
	
	@FindBy(xpath="(//h1[contains(text(), 'Discounted')])[1]")
	WebElement pagename;
	By heading =By.xpath("(//h1[contains(text(), 'Discounted')])[1]");
	

	public void SelectSubCat(String mainCatName,String subCatName) throws InterruptedException {
		
		//Select Main Category.
		selectMainCategory(mainCatName);
	
	    WebElement selectSubCategory=subCat.stream().filter(q->q.getText().equals(subCatName)).findFirst().orElse(null);
		List<String> subTitleCat = subCat.stream().map(d -> d.getText()).collect(Collectors.toList());

		List<String> subTitleCat2 = subTitleCat.stream().filter(s -> !s.trim().isEmpty()) // Only include non-empty
																							// strings
				.collect(Collectors.toList());

		subTitleCat2.stream().forEach(y -> System.out.println(y));
		System.out.println(subTitleCat2.size());
		
		selectSubCategory.click();
		
		
		
		


	}
	
	public SelectedBookPage selecttheBook(String bookName) {
		
		waitForElementToAppear(heading);
		WebElement myBook=	listOfBooks.stream().filter(book->book.getText().equals(bookName)).findFirst().orElse(null);
		myBook.click();
		
		SelectedBookPage SelectBook= new SelectedBookPage(driver);
		return SelectBook;
		
	}
	
	
	public String getCurrentPagename() {
		
	
        String result = pagename.getText().replace("Discounted", "").replace("Books", "").trim();
        System.out.println(result);
        return result;

		
	}



}
