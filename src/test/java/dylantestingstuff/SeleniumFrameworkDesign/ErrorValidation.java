package dylantestingstuff.SeleniumFrameworkDesign;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dylantestingstuff.TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest {
	
	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException {
		String productName = "ZARA COAT 3";
		
		//WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//LandingPage landingPage = new LandingPage(driver);
		//landingPage.goTo();
		landingPage.loginApplication("misterdcs92@gmail.com", "199922dst!taN19992");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		
	}
	
	@Test
	public void ProductErrorValidation() throws IOException {
		String productName = "ZARA COAT 3";		
		ProductCatalogue productCatalogue = landingPage.loginApplication("misterdcs92@gmail.com", "1999222dst!taN1999222");		
		List<WebElement> products = productCatalogue.getProductList();		
		productCatalogue.addProductToCart(productName);		
		CartPage cartPage = productCatalogue.goToCartPage();	
		Boolean match = cartPage.VerifyProductDisplay(productName);
		
		Assert.assertTrue(match);
		//Assert.assertFalse(match);
		
		/*
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equals("THANKYOU FOR THE ORDER."));
		*/
		
	}
	

}
