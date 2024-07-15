package RahulShettyAcademy.TestCopmponets;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RahulShettyAcademy.Tests.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;
    public landingPage LandingPage;

    
   
    public WebDriver initializeDriver() throws IOException {
        // Properties class
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\test\\java\\RahulShettyAcademy\\rescources\\globelData.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser")!= null ?  System.getProperty("browser"):prop.getProperty("browser");
      //  prop.getProperty("browser");

        if (browserName.contains("chrome")) {
        	ChromeOptions options =new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(browserName.contains("headless"))
            {
            options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1400,900));   
           
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            landingPage LandingPage = new landingPage(driver);
            LandingPage.goTo();
        }
        // Add support for other browsers here

        return driver;
    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
    	    	
    	
    	String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

    	//stringto HashMap-jason databind
    	ObjectMapper mapper= new ObjectMapper ();
    	List<HashMap<String,String>>data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>() {});
    	return data;
    	
    }	
    public  String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
    	
    	
    	
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File source= ts.getScreenshotAs(OutputType.FILE);
    	  File file= new File (System.getProperty("user.dir") +"//reorts//"+testCaseName+".png");
           FileUtils.copyFile(source, file);
    	return  (System.getProperty("user.dir") +"//reorts//"+testCaseName+".png");
    	
    	
    	
    	
    }
    
    @BeforeMethod(alwaysRun = true)
    public landingPage launchApplication() throws IOException {
        // Initialize WebDriver and launch application
         driver = initializeDriver();
         LandingPage = new landingPage(driver);
        LandingPage.goTo();
        return LandingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
      
    
            driver.quit();
        }
    }

	
