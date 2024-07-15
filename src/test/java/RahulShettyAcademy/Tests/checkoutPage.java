package RahulShettyAcademy.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage extends AbstractCompounds {
	public WebDriver driver;
	
	  private By suggestion = By.cssSelector(".ta-item");
   
	  @FindBy(css = ".ta-item:nth-of-type(1)")
    private WebElement chosenCountry;


	  @FindBy(css = ".action__submit")
	  WebElement placeOrderButton;


   @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryInput;
 
	public checkoutPage(WebDriver driver) {
		 super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	
	}
	
	   public void selectCountry(String countrySelect) throws InterruptedException {
		
	    	 countryInput.click();
	    	    
	    	    // Send the country name to the input field
	    	    countryInput.sendKeys(countrySelect);
	
	    	 WaitElmentToAppear(suggestion);
	    	 	
	    	 chosenCountry .click();
	    	   
	            // Move to the element
	     
	   }
	    	    public confirmationPage placeOrder() throws InterruptedException {
	    
	    	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	    	    WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
	    	    	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    	    js.executeScript("arguments[0].click();", clickableElement);
	    	    	    return new confirmationPage(driver);
	    	    
	    	    }

}




