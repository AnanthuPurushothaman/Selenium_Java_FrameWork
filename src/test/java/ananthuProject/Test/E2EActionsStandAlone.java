package ananthuProject.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ananthuProject.PageObjects.SelectCategory;
import ananthuProject.PageObjects.SelectedBookPage;
import ananthuProject.PageObjects.ShoppingCartPage;
import ananthuProject.TestComponents.BaseTest;
import ananthuProject.TestComponents.Retry;

public class E2EActionsStandAlone extends BaseTest {
	
	
	@Test
	public void addToCart() throws InterruptedException {
		
		String mainCat="Nonfiction";
		String subCat="Business";
		String bookName="Golden: The Power of Silence in a World of Noise";
		
		SelectCategory select = new SelectCategory(driver);
		select.SelectSubCat(mainCat, subCat);
		SelectedBookPage bookPage=select.selecttheBook(bookName);
		ShoppingCartPage cartPage=bookPage.addToCart();
		cartPage.goToCart();
		Thread.sleep(3000);
	    System.out.println(cartPage.getPageTitle());
		assertEquals(cartPage.getPageTitle(),bookName);
		
	}
	

	

}
