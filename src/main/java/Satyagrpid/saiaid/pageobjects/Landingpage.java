package Satyagrpid.saiaid.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class Landingpage extends Abstractcomponent{

	 WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement username=driver.findElement(By.xpath("//input[@type='email']"));
	
	@FindBy(xpath="//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String uname,String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		loginbtn.click();
		//ProductCatalogue productCatalogue =new ProductCatalogue(driver);
		return new  ProductCatalogue(driver);
	}
	
	public void goTo()
	{
		driver.navigate().to("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage);
		 return errorMessage.getText();
		
	}

	
}
