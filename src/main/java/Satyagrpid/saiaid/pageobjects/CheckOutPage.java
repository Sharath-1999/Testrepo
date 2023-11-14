package Satyagrpid.saiaid.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class CheckOutPage extends Abstractcomponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "//*[contains(text(),'Place Order')]")
	WebElement submit;
	
	@FindBy(css = ".ta-item:nth-of-type(2)")
/*	//button[@class,'ta-item')][2]  */
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");



public void selectCountry(String countryName)
{
	Actions a = new Actions(driver);
	a.sendKeys(country, countryName).build().perform();
    waitForElementToAppear(results);
	selectCountry.click();
}

public ConfirmationPage submitOrder() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", submit);
	Thread.sleep(500); 

	submit.click();

	//ConfirmationPage confirmationPage=new ConfirmationPage(driver);
	return new ConfirmationPage(driver);
}
}