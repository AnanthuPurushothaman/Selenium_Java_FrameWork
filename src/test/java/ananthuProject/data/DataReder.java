package ananthuProject.data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ananthuProject.POJO.MainObj;

public class DataReder {

	
	public MainObj getDataFromJson() throws IOException {
		
		//read json to string
	   String contentJson=	FileUtils.readFileToString(new File("C:\\Users\\gopik\\eclipse-workspace\\BookStoreFrameWork\\src\\test\\java\\ananthuProject\\data\\SubCategory.json"));
		
	// Create ObjectMapper instance
       ObjectMapper objectMapper = new ObjectMapper();
    // Read JSON file and convert it into Java object
       MainObj category = objectMapper.readValue(contentJson, MainObj.class);
       
       
       System.out.println(category.getCategory());
       
       return category;
       
	
	}
}
