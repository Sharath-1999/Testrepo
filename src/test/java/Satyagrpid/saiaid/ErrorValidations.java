package Satyagrpid.saiaid;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Satyagrpid.saiaid.pageobjects.ProductCatalogue;
import TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{

	@Test
	public void errorvalidationTest() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingpage.loginApplication("sharath9911@gmail.com", "Sharath@2434");
		//div[@aria-label='Incorrect email or password.']
		//.ng-tns-c4-40.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		Assert.assertEquals("Incorrect email or password1.", landingpage.getErrorMessage());
		Thread.sleep(1000);
}
	
}
