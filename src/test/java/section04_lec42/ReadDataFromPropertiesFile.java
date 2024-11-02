package section04_lec42;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.Test;

public class ReadDataFromPropertiesFile
{
	@Test
	public void readData() throws IOException
	{
		// Open the properties file in reading mode
		String filePath = System.getProperty("user.dir")+"/testData/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		
		// Create Properties class object
		Properties propObj = new Properties();
		
		// Load the properties file to the properties object
		propObj.load(fis);
		
		// Read the data from the properties file
		String URL = propObj.getProperty("url");
		String email = propObj.getProperty("email");
		String password = propObj.getProperty("password");
		
		System.out.println(URL);
		System.out.println(email);
		System.out.println(password);
		
		// Read all keys from the properties file
		Set<String> allProperties = propObj.stringPropertyNames();
		System.out.println(allProperties);
		
		Set<Object> allKeys = propObj.keySet();
		System.out.println(allKeys);
		
		// Read all values from the properties file
		Collection<Object> values = propObj.values();
		System.out.println(values);
		
		fis.close();
	}
}
