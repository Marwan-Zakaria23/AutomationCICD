package RahulShettyAcademy.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationPage  extends AbstractCompounds {
	private WebDriver driver;
	
	
	
	public confirmationPage(WebDriver driver) {
		 super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	     
	}
	   @FindBy(css = ".hero-primary")
	    private WebElement confirmationMessage;
	public String getConfirmationMessage() {
		
		
		  return confirmationMessage.getText();
		
		
	}

}
