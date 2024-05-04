package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent{
   
	WebDriver driver;
	public LandingPage(WebDriver driver) 
	{   
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmails= driver.findElement(By.id("userEmail"));
	//@pagefactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement Login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement Errormessage;
	public void loginapplication(String Email,String Password)
	{
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
		Login.click();
		
		
	}
	
	public String getErrorMessage()
	{
		waitforWebelementappear(Errormessage);
		return Errormessage.getText();
		
	}
	
   public void goTo() 
   {
	   driver.get("https://rahulshettyacademy.com/client/");
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
