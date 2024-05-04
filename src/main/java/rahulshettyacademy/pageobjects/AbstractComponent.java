package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@routerlink='/dashboard/cart']")
	WebElement cart;
	@FindBy(xpath="//*[@routerlink='/dashboard/myorders']")
	WebElement orderHistroy;

	public void waitforelementappear(By FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
	}
	public void waitforWebelementappear(WebElement FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));//explicit wait
		wait.until(ExpectedConditions.visibilityOf(FindBy));
		
	}
	public void waitforelementdisappear(WebElement Ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));//explicit wait
		wait.until(ExpectedConditions.invisibilityOf(Ele));
	}

public void MovetoCartPage()
{
	cart.click();
	
}
public void MovetoOrderHistoryPage()
{
	orderHistroy.click();
	
}


}
