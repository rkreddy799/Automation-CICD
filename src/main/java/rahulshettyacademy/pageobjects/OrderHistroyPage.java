package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistroyPage extends AbstractComponent{
	
	WebDriver driver;
	public OrderHistroyPage(WebDriver driver) 
	{    
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	

	
@FindBy(css="tr td:nth-child(3)")
List<WebElement> productnames;

public Boolean getProductName(String ProductName)
{
	Boolean match=productnames.stream().anyMatch(product-> product.getText().equals(ProductName));
	return match;
}



	


}

