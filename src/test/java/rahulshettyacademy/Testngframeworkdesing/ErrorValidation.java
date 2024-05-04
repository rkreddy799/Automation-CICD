package rahulshettyacademy.Testngframeworkdesing;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.CompleteOrderPage;
import rahulshettyacademy.pageobjects.Paymentpage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;


public class ErrorValidation extends BaseTest {
    @Test(groups={"ErrorHandling"})
	public  void SubmitOrder () throws IOException {
		// TODO Auto-generated method stub
		String ProductName ="ADIDAS ORIGINAL";
		
		
		landingpage.loginapplication("ravitest@gmail.com", "Ravirama@2");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());;
		
	}
    
    @Test
    public  void Loginerror () throws IOException {
		// TODO Auto-generated method stub
		String ProductName ="ADIDAS ORIGINAL";
		
		
		landingpage.loginapplication("ravitest@gmail.com", "Ravirama@12");
		ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
		List<WebElement>products=productCatalogPage.getProductsList();
		
		productCatalogPage.getProductAddtoCart(ProductName);
		productCatalogPage.MovetoCartPage();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		
		Boolean match=checkoutpage.productvalidation("Addidas");
		Assert.assertFalse(match);
		
		
			
		
	}

    
	
}
