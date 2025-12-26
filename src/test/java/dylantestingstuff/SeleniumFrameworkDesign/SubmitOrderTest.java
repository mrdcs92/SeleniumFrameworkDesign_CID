package dylantestingstuff.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import dylantestingstuff.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LandingPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "ZARA COAT 3";
	
	@Test
	public void submitOrder() throws IOException {
		//String productName = "ZARA COAT 3";
		
		//WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//LandingPage landingPage = new LandingPage(driver);
		//landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("misterdcs92@gmail.com", "1999222dst!taN1999222");
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//driver.findElement(By.id("userEmail")).sendKeys("misterdcs92@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("1999222dst!taN1999222");
		//driver.findElement(By.id("login")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		
		productCatalogue.addProductToCart(productName);
		
		//WebElement prod = products.stream().filter(product -> 
		//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		CartPage cartPage = productCatalogue.goToCartPage();
		
		//CartPage cartPage = new CartPage(driver);
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		
		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		//Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(match);
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
		
		//Actions a = new Actions(driver);
		//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		//driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equals("THANKYOU FOR THE ORDER."));

		//driver.quit();
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("misterdcs92@gmail.com", "1999222dst!taN1999222");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
	}

}
