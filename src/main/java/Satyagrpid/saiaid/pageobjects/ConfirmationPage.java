package Satyagrpid.saiaid.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class ConfirmationPage extends Abstractcomponent{


	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".hero-primary")
	static
	WebElement confirmMessage;
	
	public static String getConfirmMessage()
	{
		
		return confirmMessage.getText();
	}
}
