package RahulShettyAcademy.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends AbstractCompounds {
    // Define WebDriver instance
    private WebDriver driver;

    // Define WebElement elements using @FindBy annotations
    @FindBy(id="userEmail")
    private WebElement userEmail;

    @FindBy(id="userPassword")
    private WebElement Passwordele;

    @FindBy(id="login")
    private WebElement Sumit;
    @FindBy(css = "#toast-container")
    private WebElement errorMessage;
    
   

    

    // Constructor
    public landingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to login to the application
    public productCart loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        Passwordele.sendKeys(password);
        Sumit.click();
        return new productCart(driver);
    }

 public String getErrorMessage(){
	 
	 WaitElmentOfWebelmentToAppear(errorMessage);
	 errorMessage.getText();
	 
	 return   errorMessage.getText();
 }
    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
