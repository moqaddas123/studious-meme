package assignment4;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class assignment4 {


	
	
	//Element Library
	
	By UserName =By.xpath("//input[@id='username']");
	By PassWord=By.xpath("//input[@id='password']");
	By SignInButton=By.xpath("//button[contains(text(),'Sign in')]");
	
	@Test
	public void practice4() {
		System.setProperty("webdriver.gecko.driver", "./firefoxdriver/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(UserName).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(PassWord).sendKeys("abc123");
		driver.findElement(SignInButton).click();
		
		
		
		
//		driver.findElement(By.linkText("CRM")).click();
//		driver.findElement(By.linkText("Add Contact")).click();
//		driver.findElement(By.id("account")).sendKeys("Moqaddas Langah");
//		driver.findElement(By.id("company")).sendKeys("TechFios");
//		driver.findElement(By.id("email")).sendKeys("mbl2253@gmail.com");
//		driver.findElement(By.id("phone")).sendKeys("7032297050");
//		driver.findElement(By.id("address")).sendKeys("123 askjdhsjak");
//		driver.findElement(By.id("city")).sendKeys("dallas");
//		driver.findElement(By.id("state")).sendKeys("Texas");
//		driver.findElement(By.id("zip")).sendKeys("22191");
//		driver.findElement(By.id("submit")).click();
//		driver.findElement(By.linkText("List Contacts")).click();
//		By contact =By.linkText("Moqaddas Langah");
//		
//		Assert.assertTrue("failed", (driver.findElement(contact).isDisplayed()));
	}

}
