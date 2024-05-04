package rahulshettyacademy.Testngframeworkdesing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.CompleteOrderPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderHistroyPage;
import rahulshettyacademy.pageobjects.Paymentpage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;


public class submitpage extends BaseTest {
	//String ProductName ="ADIDAS ORIGINAL";
    @Test(dataProvider="getData",groups= {"purchase1"})
	public  void SubmitOrder (HashMap<String,String> input ) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		landingpage.loginapplication(input.get("email"), input.get("password"));
		ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
		List<WebElement>products=productCatalogPage.getProductsList();
		
		productCatalogPage.getProductAddtoCart(input.get("product"));
		productCatalogPage.MovetoCartPage();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		
		Boolean match=checkoutpage.productvalidation(input.get("product"));
		Assert.assertTrue(match);
		checkoutpage.clickonCheckoutButton();
		Paymentpage paymentpage = new Paymentpage(driver);
		
		paymentpage.selectCountry("ind");
		paymentpage.submitorder();
		CompleteOrderPage completeorderpage = new CompleteOrderPage(driver);
		String confirmessage2=completeorderpage.comparetextmsg();
		Assert.assertTrue(confirmessage2.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
		
	}

    @Test( groups={"purchase"},dataProvider= "getData")
   //dependsOnMethods= {"SubmitOrder"}
    public void OrderHistroy(HashMap<String,String> input )
    {
    	landingpage.loginapplication(input.get("email"), input.get("password"));
    	landingpage.MovetoOrderHistoryPage();
    	
    	OrderHistroyPage orderHistroyPage = new OrderHistroyPage(driver);
    	Assert.assertTrue(orderHistroyPage.getProductName(input.get("product")));	
    }
    @DataProvider
    public Object[][] getData() throws IOException 
    {
    	
    	
    	List<HashMap<String,String>> data =getJsondatatoMap(System.getProperty("user.dir\")+\"\\\\src\\\\test\\\\java\\\\rahulshettyacademy\\\\data\\\\data.json\"),StandardCharsets.UTF_8"));
    	
    	return new Object[][] {{data.get(0)},{data.get(1)}};
    }
  
    //@DataProvider-first type
  /* public Object[][] getData() 
    {
      return new Object[][] {{"ravitest@gmail.com","Ravirama@12","ZARA COAT 3"},{"ravitest@gmail.com","Ravirama@12","ZARA COAT 3"}};
    }
    */
    /*HashMap<String,String> map= new HashMap<String,String>();
	map.put("email", "ravitest@gmail.com");
	map.put("password", "Ravirama@12");
	map.put("product", "ADIDAS ORIGINAL");
	
	HashMap<String,String> map1= new HashMap<String,String>();
	map1.put("email", "ravitest1@gmail.com");
	map1.put("password", "Ravirama12@");
	map1.put("product", "ZARA COAT 3");
	*/
	
}
