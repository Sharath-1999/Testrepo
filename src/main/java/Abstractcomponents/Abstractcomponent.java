package Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Satyagrpid.saiaid.pageobjects.CartPage;


public class Abstractcomponent  {

	public WebDriver driver;

	public Abstractcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement carHeader;
	

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForElementToAppear(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elem));

	}
	
	
	public void waitForElementToDisapper(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
<<<<<<< HEAD
			}
=======
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}
>>>>>>> 66d399c6ac92fbf4dcc84210a2809671cf95ae83
	
	public CartPage goToCartPage()
	{
		carHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
