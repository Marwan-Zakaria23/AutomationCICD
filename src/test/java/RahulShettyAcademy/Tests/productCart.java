package RahulShettyAcademy.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCart extends AbstractCompounds {
    // Define WebDriver instance
    private WebDriver driver;

    // Define WebElement elements using @FindBy annotations
    @FindBy(css= ".ng-animating")
    private WebElement spinner;

    @FindBy(css= ".mb-3")
    private List<WebElement> products;

    private By productsBy = By.cssSelector(".mb-3");
    private By addToCart = By.cssSelector(".card-body button:last-of-type");
    private By toastMessage = By.cssSelector("#toast-container");

    // Constructor
    public productCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to retrieve the list of products
    public List<WebElement> getProductList() {
    	WaitElmentToAppear(productsBy);
        return products;
    }

    // Method to get product WebElement by name
    public WebElement getProductByName(String productName) {
        return getProductList().stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst().orElse(null);
    }

    // Method to add a product to the cart
    public cartPage addProductToCart(String productName) throws InterruptedException {
        WebElement product = getProductByName(productName);
        
            product.findElement(addToCart).click();
            WaitElmentToAppear(toastMessage);
            waitForElmentDisaaper(spinner);
            return new cartPage(driver);
        }
    }



