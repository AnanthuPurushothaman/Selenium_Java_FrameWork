package ananthuProject.POJO;

import java.util.List;

public class MainObj {

	
	private List<String> category;
	private List<String>subcategories;
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public List<String> getSubcategories() {
		return subcategories;
	}
	  public void setSubcategories(List<String> subcategories) {
	        this.subcategories = subcategories;  // Corrected the issue
	    }
}
