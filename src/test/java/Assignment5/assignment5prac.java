package Assignment5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment5prac {


	
	By UserName =By.xpath("//input[@id='username']");
	By PassWord=By.xpath("//input[@id='password']");
	By SignInButton=By.xpath("//button[contains(text(),'Sign in')]");
	WebDriver driver;
	@BeforeTest
	public void SetProperties() {
		System.setProperty("webdriver.gecko.driver", "./firefoxdriver/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		
		driver.findElement(UserName).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(PassWord).sendKeys("abc123");
		driver.findElement(SignInButton).click();	
		driver.findElement(By.xpath("//span[contains(text(),'Bank')]")).click();
		driver.findElement(By.xpath("//ul[@class='nav nav-second-level collapse in']/descendant::a")).click();
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);
		String AccountTitle = "Moqaddas"+randomNumber;
		String InitialBalance = String.valueOf(randomNumber);;
		driver.findElement(By.xpath("//div[@class='form-group']/child::input[@name='account']")).sendKeys(AccountTitle);
		driver.findElement(By.xpath("//div[@class='form-group']/child::input[@name='description']")).sendKeys("College Fund");
		driver.findElement(By.xpath("//div[@class='form-group']/child::input[@name='balance']")).sendKeys(InitialBalance);
		driver.findElement(By.xpath("//form[@name='accadd']/child::button")).click();
		By add_success=By.xpath("//div[@class='alert alert-success fade in']");
	
		Assert.assertTrue("failed", (driver.findElement(add_success).isDisplayed()));
	
	}
//	@AfterTest
//	public void TearDown() throws InterruptedException  {
//	Thread.sleep(5000);
//	driver.close();
//	driver.quit();
//	
//	}

}
