package RahulShettyAcademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import RahulShettyAcademy.TestCopmponets.BaseTest;
import RahulShettyAcademy.Tests.cartPage;
import RahulShettyAcademy.Tests.checkoutPage;
import RahulShettyAcademy.Tests.confirmationPage;
import RahulShettyAcademy.Tests.landingPage;
import RahulShettyAcademy.Tests.productCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImpl extends BaseTest {
	 public landingPage LandingPage;
	 public  productCart ProductCart;
	 public checkoutPage CheckoutPage;
	public 	confirmationPage ConfirmationPage;
	
	@Given("I landed on Ecommerce Page")

	public void I_landed_on_Ecommerce_Page() throws IOException 

	{

		 LandingPage  =  launchApplication();

	}
	@Given("Logged in with username {string} and password {string}")
	    public void Given_Logged_in_with_username_and_password(String username, String password) {
	        ProductCart = LandingPage.loginApplication(username, password);
	   
	  
	  
	 
	  }

	
	@When ("I add the product {string}  to cart")

	public void When_I_add_product_to_cart(String productName) throws InterruptedException

	{

		List<WebElement> products = ProductCart.getProductList();
        ProductCart.addProductToCart(productName);

	}


	@When("checkout the cart with product {string} and submit it")

	public void Checkout_productName_and_submit_the_order(String productName) throws InterruptedException

	{

		 cartPage CartPage = ProductCart.goToCartpage();

	        boolean match = CartPage.verifyProductsDisplay(productName);
	        Assert.assertTrue(match);

	        CartPage.checkout();

	         CheckoutPage = new checkoutPage(driver);
	        CheckoutPage.selectCountry("egypt");
	   
	         ConfirmationPage = CheckoutPage.placeOrder();

	}
	@Then("{string} message is displayed")

	public void message_is_displayed_on_ConfirmationPage(String string)

	{

		   String confMessage = ConfirmationPage.getConfirmationMessage();
	        Assert.assertEquals(confMessage, string);
driver.close();
	}
	
	@Then ("{string} error message is displayed .")

	public void error_message_is_displayed(String sTring) {
		
		Assert.assertEquals(sTring, "Incorrect email or password.");

		
		driver.close();
		
	}




}
