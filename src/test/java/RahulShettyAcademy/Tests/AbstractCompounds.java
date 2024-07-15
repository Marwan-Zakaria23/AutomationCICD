package RahulShettyAcademy.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test


public class AbstractCompounds {
	WebDriver driver;

	public AbstractCompounds(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css= "[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css= "[routerlink*='myorders']")
	WebElement orderHeader;


	public void WaitElmentToAppear(By FindBy) {
	
	WebDriverWait wait=new  WebDriverWait (driver,Duration.ofSeconds(20));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	
	}

	public void WaitElmentOfWebelmentToAppear(WebElement FindBy) {
	
	WebDriverWait wait=new  WebDriverWait (driver,Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	public cartPage goToCartpage() {
		
		
		cartHeader.click();
		cartPage CartPage=new  cartPage(driver);
		return CartPage;
		
		
		
	}
	public orderPage goToOrderpage() {
		
		

		orderHeader.click();
		orderPage OrderPage=new  orderPage(driver);
		return OrderPage;
		
	}
public void waitForElmentDisaaper(WebElement ele) throws InterruptedException {
Thread.sleep(2000);
	//WebDriverWait wait=new  WebDriverWait (driver,Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.invisibilityOf(ele));



}

}



