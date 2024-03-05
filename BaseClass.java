package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	
	WebDriver driver = new ChromeDriver();
	PropertyFileUtil putil = new PropertyFileUtil();
	WebdriverUtil wutil = new WebdriverUtil();
	
	@BeforeSuite
	public void BSuite() {
		
		
		System.out.println("Connect to data base");
	}
	
	@BeforeClass                                                              // @BeforeClass is used to launch the application
	public void Bclass() throws IOException {
		//launch the browser
		
		wutil.maximize(driver);
		wutil.implicitwait(driver);
		
		// To read the data from property file
		String URL = putil.getDataFromPropertyFile("Url");
		
		// to launch application
			driver.get(URL);
	}
	
	@BeforeMethod                                                              //@BeforeMethod is used to login to the application
	public void Bmethod() throws IOException {
		// To read the data from property file
				
				String Username = putil.getDataFromPropertyFile("Username");
				String password = putil.getDataFromPropertyFile("Password");
				
				// login to application
				driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterClass                                                                //@AfterClass is used to close the browser
	public void Aclass() {
		driver.quit();
	}
	
	@AfterMethod                                               // @AfterMethod is used to sign-out from application
	public void Amethod() throws InterruptedException {
		
		Thread.sleep(2000);
		// Mouse hover on image
				WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				wutil.mousehover(driver, image);
				
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
	}
	
	@AfterSuite
	public void Asuite() {
		System.out.println("Disconnect from data base");
	}
	
	
	
	
	
	
}
