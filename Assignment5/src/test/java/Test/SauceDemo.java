package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Demo.DataDriven;
import Demo.DataDrivenDemo;
import Helper.ExcelHelper;

public class SauceDemo {
	
//	@Test(dataProvider = "credential", dataProviderClass = DataDrivenDemo.class)
//	public void testLogin(String username, String password) {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\daoch\\eclipse-workspace\\Assignment5\\Drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://phptravels.net/api/admin");
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.id("user-name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id("Login-button")).click();
//		
//		
//	}
	
	
	public static WebDriver driver;
	public static Actions action;
	
	@BeforeSuite
	public void setUp() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\daoch\\eclipse-workspace\\Assignment5\\Drivers\\chromedriver1.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get("https://www.phptravels.net/admin");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	@Test()
	public void Login() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[contains(@name,'email') and @type = 'text']")).sendKeys("admin@phptravels.com");
		driver.findElement(By.xpath("//*[contains(@name,'password')]")).sendKeys("demoadmin");
		driver.findElement(By.cssSelector(".btn-block")).click();
		Thread.sleep(3000);
//		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@href,\"https://phptravels.net/api/admin/profile\")]")).isDisplayed(),"Dashboard page is not displayed ");
		
	}
	
	@Test()
	public void ToHotelPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(@href,'javascript:void(0);#hotelsmodule')]")).click();
		
//		action.moveToElement(driver.findElement(By.xpath("//*[contains(@href,'#Hotels')]"))).moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Hotels') and @href = 'https://phptravels.net/api/admin/hotels' ]"))).click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[contains(@href,'#Hotels')]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Hotels') and @href = 'https://www.phptravels.net/api/admin/hotels' ]")).submit();
		                             
		Thread.sleep(3000);
		
	}
	
	@Test(dataProvider = "credential", dataProviderClass = DataDriven.class)
	public void AddHotel(String name, String description, String location) throws InterruptedException {
		driver.findElement(By.cssSelector(".btn-success")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains(@name,'hotelname') ]")).sendKeys(name);
		
		WebElement iframeElements = driver.findElement(By.xpath("//iframe[contains(@title,'hoteldesc')]"));
		driver.switchTo().frame(iframeElements);
		driver.findElement(By.cssSelector("body p")).sendKeys(description);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@class='select2-container locationlist']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='select2-search']//*[contains(@class,'select2-input')]")).sendKeys(location);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".select2-result")).click();
		
		driver.findElement(By.cssSelector(".btn-lg")).click();
		
	}
	
	@AfterSuite
	public void AfterSuite() {
		driver.quit();
	}

}
