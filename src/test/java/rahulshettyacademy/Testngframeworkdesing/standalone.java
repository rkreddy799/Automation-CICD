package rahulshettyacademy.Testngframeworkdesing;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;


public class standalone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

                //new commands added
		String ProductName ="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("ravitest@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ravirama@12");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3 ")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3 "));
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body  button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']")).click();
	
		List<WebElement> names=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		Boolean match= names.stream().anyMatch(name->name.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//*[@class='subtotal cf ng-star-inserted']//*[@type='button']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath("(//*[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
		
		driver.findElement(By.xpath("//*[@class='btnn action__submit ng-star-inserted']")).click();
	
		String Confirmmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
