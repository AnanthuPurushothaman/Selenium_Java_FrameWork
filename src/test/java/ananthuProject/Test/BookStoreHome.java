package ananthuProject.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ananthuProject.POJO.MainObj;
import ananthuProject.PageObjects.LandingPage;
import ananthuProject.PageObjects.SelectCategory;
import ananthuProject.TestComponents.BaseTest;
import ananthuProject.TestComponents.Retry;
import ananthuProject.data.DataReder;

public class BookStoreHome extends BaseTest{


		@Test
		public void checkFooterLinks() throws InterruptedException {

			landingpage.getFooterTitle();
			
			//System.out.println(landingpage.getLandingPageTitle());
			
			
		}
		
		@Test(dataProvider="testdtaTest")
		public void goToCategory(String mainCat,String subCat) throws InterruptedException {
			
			SelectCategory selCat= new SelectCategory(driver);
			String mainCategory=mainCat;
			String SubCategory=subCat;
			selCat.SelectSubCat(mainCategory,SubCategory);
			boolean result=selCat.checkForPageHeading();
			assertTrue(result);
		}
		
		
		
		
		
		@DataProvider
		public Object[][] testdtaTest() throws IOException {
			
			DataReder datar= new DataReder();
			MainObj obj=datar.getDataFromJson();
			
			
			List<String> li= obj.getSubcategories();
		
			List<String>li1= obj.getCategory();
			  int size = Math.min(li1.size(), li.size()); // Get the smaller list size

			    Object[][] testData = new Object[size][2]; // Create a 2D array

			    for (int i = 0; i < size; i++) {
			        testData[i][0] = li1.get(i);   // First column: Category
			        testData[i][1] = li.get(i); // Second column: Subcategory
			    }

			    return testData; // Return 2D arra
			
		}
		
		
		
		

}
