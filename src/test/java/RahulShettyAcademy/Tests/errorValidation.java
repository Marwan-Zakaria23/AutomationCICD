package RahulShettyAcademy.Tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestCopmponets.BaseTest;
import RahulShettyAcademy.data.Retry;

public class errorValidation extends BaseTest {
    



    @Test(groups={"errorHandling"},retryAnalyzer=Retry.class)
    public void errorMessagetest() throws InterruptedException, IOException {
        String productName = "ADIDAS ORIGINAL";
        String countrySelect = "Egypt";

        productCart ProductCart = LandingPage.loginApplication("marwan9@gmail.com", "Liverpool@");

        String errorMessage = LandingPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Incorrect email  password.");


    }

  @Test
    public void WrongProduct() throws InterruptedException, IOException {
        String productName = "ADIDAS ORIGINAL";
        String countrySelect = "Egypt";

        productCart ProductCart = LandingPage.loginApplication("marwan23@gmail.com", "Liverpool@239");

        List<WebElement> products = ProductCart.getProductList();
        ProductCart.addProductToCart(productName);
        cartPage CartPage = ProductCart.goToCartpage();

        boolean match = CartPage.verifyProductsDisplay("ADIDAS ORIGINAL11");
        Assert.assertFalse(match);

  
    }}
    