package Satyagrpid.saiaid;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Satyagrpid.saiaid.pageobjects.CartPage;
import Satyagrpid.saiaid.pageobjects.CheckOutPage;
import Satyagrpid.saiaid.pageobjects.ConfirmationPage;
import Satyagrpid.saiaid.pageobjects.ProductCatalogue;
import TestComponents.BaseTest;

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
		Thread.sleep(8000);
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
