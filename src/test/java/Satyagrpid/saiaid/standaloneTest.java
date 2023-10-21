package Satyagrpid.saiaid;

import java.time.Duration;
import java.util.List;

import org.bouncycastle.its.ITSValidityPeriod.Unit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Satyagrpid.saiaid.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class standaloneTest {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	
	String productName="ZARA COAT 3";
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.navigate().to("https://rahulshettyacademy.com/client");
	Landingpage landingpage=new Landingpage(driver);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sharath99@gmail.com");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sharath@24");
	driver.findElement(By.xpath("//input[@name='login']")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	
	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	WebElement prod=  products.stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	Actions a =new Actions(driver);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	
	
	driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	
	
	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	boolean match=cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India")
	.build()
	.perform();
	
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
	boolean rightmessage=confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	Assert.assertTrue(rightmessage);
	System.out.println("Product is finally placed");
	driver.close();
}
}
