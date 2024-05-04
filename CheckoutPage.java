package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) 
	{    
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	

@FindBy(xpath="//*[@class='cartSection']/h3")
List<WebElement> names;
	
@FindBy(xpath="//*[@class='subtotal cf ng-star-inserted']//*[@type='button']")
WebElement Checkoutbutton;



public Boolean productvalidation(String ProductName)
{

	Boolean match= names.stream().anyMatch(name->name.getText().equalsIgnoreCase(ProductName));
	return match;
}
public void clickonCheckoutButton()
{
	Checkoutbutton.click();
	
	
}
	


}

