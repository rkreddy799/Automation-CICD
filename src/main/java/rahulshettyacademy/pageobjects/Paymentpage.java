package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Paymentpage extends AbstractComponent{
	private static final By CountryLsit = null;
	WebDriver driver;
	public Paymentpage(WebDriver driver) 
	{    
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement country;	
	//By CountryList=By.xpath("//*[@class='ta-results list-group ng-star-inserted']");
	
	@FindBy(css=(".ta-item:nth-child(3)"))
	WebElement countrySelect;	
	
	@FindBy(xpath="//*[@class='btnn action__submit ng-star-inserted']")
	WebElement orderplace;
	
	By results=By.cssSelector(".ta-results");
	@FindBy(css=".hero-primary")
	WebElement thankutext;
	

	public void selectCountry(String CountryName)
	{
		country.sendKeys(CountryName);
		waitforelementappear(By.cssSelector(".ta-results"));
		countrySelect.click();
				
	}
	public void submitorder()
	{
		orderplace.click();
		
		

	}
	
		
	
	

}
