package section04_lec42;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage
{
	private WebDriver driver;
	
	public CalculatorPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#principal")
	private WebElement principal;
	
	public WebElement getPrincipal()
	{
		return this.principal;
	}
	
	@FindBy(id = "interest")
	private WebElement rateOfInterest;
	
	public WebElement getRateOfInterest()
	{
		return this.rateOfInterest;
	}
	
	@FindBy(name = "tenure")
	private WebElement period;
	
	public WebElement getPeriod()
	{
		return period;
	}
	
	@FindBy(id = "tenurePeriod")
	private WebElement tenurePeriod;
	
	public WebElement getTenurePeriod()
	{
		return tenurePeriod;
	}
	
	public void setTenurePeriod(String tenure)
	{
		Select select = new Select(tenurePeriod);
		select.selectByVisibleText(tenure);
	}
	
	@FindBy(id = "frequency")
	private WebElement frequency;
	
	public WebElement getSelectFrequency()
	{
		return frequency;
	}
	
	public void setFrequency(String frequency)
	{
		Select select = new Select(this.frequency);
		select.selectByVisibleText(frequency);
	}
	
	@FindBy(xpath = "//img[contains(@src, 'btn_calcutate.gif')]")
	private WebElement calculateButton;
	
	public WebElement getCalculateButton()
	{
		return calculateButton;
	}
	
	@FindBy(id = "resp_matval")
	private WebElement actualMaturityValue;
	
	public WebElement getActualMaturityValue()
	{
		return this.actualMaturityValue;
	}
	
	@FindBy(xpath = "//*[@class='PL5']")
	private WebElement clearButton;
	
	public WebElement getClearButton()
	{
		return clearButton;
	}
	
	@FindBy(xpath = "//button[text()='No thanks']")
	private WebElement noThanksButton;
	
	public WebElement getNoThanksButton()
	{
		return this.noThanksButton;
	}
}
