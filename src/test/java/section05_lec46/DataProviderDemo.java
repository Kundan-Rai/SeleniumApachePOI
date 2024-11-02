package section05_lec46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo 
{
	@Test(dataProvider = "dp")
	public void readData(String email, String password)
	{
//		System.out.println(email+" --- "+password);
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement emailAdd = driver.findElement(By.id("input-email"));
//		emailAdd.clear();
		emailAdd.sendKeys(email);
		WebElement pwd = driver.findElement(By.cssSelector("[placeholder='Password']"));
//		pwd.clear();
		pwd.sendKeys(password);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		driver.close();
		
	}
	
	@DataProvider(name = "dp", indices = {0, 2, 4}, parallel = true )
	public Object[][] loginData()
	{
		Object[][] data = {
				
				{"abc@gmail.com", "test123"},
				{"xyz@gmail.com", "test012"},
				{"john@gmail.com", "test@123"},
				{"pavanol123@gmail.com", "test@123"},
				{"johncanedy@gmail.com", "test"}
		};
		return data;
	}
}
