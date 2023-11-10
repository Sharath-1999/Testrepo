package Satyagrpid.saiaid;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Abstractcomponents.Abstractcomponent;
import Satyagrpid.saiaid.pageobjects.CartPage;
import Satyagrpid.saiaid.pageobjects.CheckOutPage;
import Satyagrpid.saiaid.pageobjects.ConfirmationPage;
import Satyagrpid.saiaid.pageobjects.Landingpage;
import Satyagrpid.saiaid.pageobjects.ProductCatalogue;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {

	@Test
	public void submitOrderTest() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingpage.loginApplication("sharath99@gmail.com", "Sharath@24");
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);

		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckOutPage checkoutpage = cartPage.goTocheckOut();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();

		String confirmMessage = ConfirmationPage.getConfirmMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Product is finally placed");
		

	}
	
	
	
	@Test//(dependsOnMethods={"submitOrderTest"})
	public void verifyOrderHistory()
	{
		System.out.println("This is a test to check depends on methods concept");
	}
	
	

}
