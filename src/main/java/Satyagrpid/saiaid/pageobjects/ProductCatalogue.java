package Satyagrpid.saiaid.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.Abstractcomponent;

public class ProductCatalogue extends Abstractcomponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username=driver.findElement(By.xpath("//input[@type='email']"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	 
	@FindBy(css=".ng-animating")
	WebElement spinner;

	By productsby = By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastmessage=(By.cssSelector("#toast-container"));

	public List<WebElement> getProductsList()
	{
		waitForElementToAppear(productsby);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod=  getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastmessage);
		waitForElementToDisapper(spinner);
	}
	
	

}
