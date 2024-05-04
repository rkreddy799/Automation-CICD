package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogPage extends AbstractComponent {
   
	WebDriver driver;
	public ProductCatalogPage(WebDriver driver) 
	{    
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmails= driver.findElement(By.id("userEmail"));
	//@pagefactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productsList= By.cssSelector(".mb-3");
	By AddtoCart= By.cssSelector(".card-body  button:last-of-type");
	By toastMessage=By.id("toast-container");
	
	
	public List<WebElement> getProductsList()
	{
		waitforelementappear(productsList);
		return products;
		
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void getProductAddtoCart(String ProductName){
		{
			WebElement prod=getProductByName(ProductName);
			prod.findElement(AddtoCart).click();
			waitforelementappear(toastMessage);
			waitforelementdisappear(spinner);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
