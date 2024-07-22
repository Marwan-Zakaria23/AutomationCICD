package RahulShettyAcademy.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestCopmponets.BaseTest;
import RahulShettyAcademy.data.Retry;

public class StandAloneTest extends BaseTest {
	//add comment
	//now

	  String productName = "ADIDAS ORIGINAL";
      String countrySelect = "Egypt";

	    @Test(dataProvider="getData",groups= {"purchase"})
	    public void FirstTest( HashMap<String, String> input) throws InterruptedException, IOException {
	    	String countrySelect = "Egypt";
	        productCart ProductCart = LandingPage.loginApplication(input.get("email"),input.get("password"));

	        List<WebElement> products = ProductCart.getProductList();
	        ProductCart.addProductToCart(input.get("productname"));
	        cartPage CartPage = ProductCart.goToCartpage();

	        boolean match = CartPage.verifyProductsDisplay(input.get("productname"));
	        Assert.assertTrue(match);

	        CartPage.checkout();

	        checkoutPage CheckoutPage = new checkoutPage(driver);
	        CheckoutPage.selectCountry(countrySelect);
	   
	        confirmationPage ConfirmationPage = CheckoutPage.placeOrder();
	        String confMessage = ConfirmationPage.getConfirmationMessage();
	        Assert.assertEquals(confMessage, "THANKYOU FOR THE ORDER.");
	       
	    }
	    @Test(dependsOnMethods = {"FirstTest"},dataProvider="getData")
	  public void orderHistoryTest( HashMap<String, String> input) throws IOException {
		  

		     
	  
	    productCart ProductCart = LandingPage.loginApplication(input.get("email"),input.get("password"));
		  
	  orderPage OrderPage=ProductCart.goToOrderpage();
	

Assert.assertTrue(OrderPage.verifyProductsDisplay(input.get("productname")));
		 
	      
		  
	 }

	    
	    @DataProvider
	   public Object[][] getData() throws IOException {

	    	
	    	List<HashMap<String,String>> data = getJsonDataToMap((System.getProperty("user.dir") +"//src//test//java//RahulShettyAcademy//data//purcahaseOrder.json"));
	    	
 return new Object [] []  {{data.get(0)},{data.get(1)}};
		   

		   
	//HashMap<String, String>map=new HashMap <String, String>();
	//map.put("email", "marwan23@gmail.com");
	//map.put("password", "Liverpool@239");
	//map.put("productname", "ADIDAS ORIGINAL");
	//HashMap<String, String>map1=new HashMap <String, String>();
//	map1.put("email"," marwan9@gmail.com");
	//map1.put("password", "Marwan@239");
	//map1.put("productname","IPHONE 13 PRO");
		   
 //java -jar jenkins.war -httpPort-8080

// <dependency>
// <groupId>org.apache.maven.plugins</groupId>
// <artifactId>maven-compiler-plugin</artifactId>
 //<version>3.13.0</version>
//</dependency>
	   }
	     
}