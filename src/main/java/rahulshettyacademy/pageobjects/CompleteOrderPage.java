package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CompleteOrderPage  extends AbstractComponent {

	
	WebDriver driver;
		
		public CompleteOrderPage(WebDriver driver) {
		super(driver);   
			 
			 this.driver=driver;
			 PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".hero-primary")
		WebElement thankutext;	
		
		
		public String comparetextmsg() {
			
			return thankutext.getText();
		}
}


