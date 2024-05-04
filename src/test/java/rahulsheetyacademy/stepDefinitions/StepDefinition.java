package rahulsheetyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.CompleteOrderPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.Paymentpage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class StepDefinition extends BaseTest{
	public LandingPage landingpage;
	String product;
	public CompleteOrderPage completeorderpage;
	@Given("I landed on ECOOM page")
	public void I_landed_on_Ecom_page() throws IOException
	{
		landingpage=launchsite();
	}
	
	
	@Given("^I want to login with username (.+) and password (.+)$")
	public void loggedin_username_password(String username,String password)
	{
		landingpage.loginapplication(username,password);
	}
	@When("^Add Product (.+) to cart $")
	public void Add_product_to_cart()
	{
		ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
		List<WebElement>products=productCatalogPage.getProductsList();
		productCatalogPage.getProductAddtoCart(product);
		productCatalogPage.MovetoCartPage();
		
	}
	@When("^checkout (.+) and Submit the order$")
	public void submit_order(String prodcut)
	{
		
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		Boolean match=checkoutpage.productvalidation(product);
		Assert.assertTrue(match);
		checkoutpage.clickonCheckoutButton();
		Paymentpage paymentpage = new Paymentpage(driver);
		
		paymentpage.selectCountry("ind");
		paymentpage.submitorder();
		completeorderpage = new CompleteOrderPage(driver);

	}
	@Then("{string} message displayed on confirmation page")
	public void messageon_confirmationpage(String string)
	{
		String confirmessage2=completeorderpage.comparetextmsg();
		Assert.assertTrue(confirmessage2.equalsIgnoreCase(string));	
		driver.close();
	}
	
	@Then("{string} message displayed ")
	public void error_message_is_displayed(String string1)
	{
		Assert.assertEquals(string1,landingpage.getErrorMessage());;
		driver.close();	}	
}
