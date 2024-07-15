package RahulShettyAcademy.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
@Test

public class orderPage extends AbstractCompounds {
    private WebDriver driver;
    @FindBy(css = ".totalRow button")
    private WebElement checkoutButton;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productsName;

    public orderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyProductsDisplay(String productName) {
       
    	
    
    	return	productsName.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    
   
    }

}