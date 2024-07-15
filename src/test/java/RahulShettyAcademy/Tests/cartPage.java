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

public class cartPage extends AbstractCompounds {
    private WebDriver driver;
    @FindBy(css = ".totalRow button")
    private WebElement checkoutButton;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    public cartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyProductsDisplay(String productName) {
        return cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    }

    public checkoutPage checkout() throws InterruptedException {
      
        checkoutButton.click();
      return new checkoutPage(driver);
    }


}