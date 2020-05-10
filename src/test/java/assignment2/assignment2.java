package assignment2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

public class assignment2 {

@Test
public void abc() throws InterruptedException {
	
	System.setProperty("webdriver.gecko.driver", "./firefoxdriver/geckodriver");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://techfios.com/test/billing/?ng=admin/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("techfiosdemo@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
	driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Add D')]")).click();
	//driver.findElement(By.id("select2-account-container")).click();
	//Thread.sleep(5000);
	//driver.findElement(By.xpath("//ul[@class='select2-results__options']/child::li[5]")).click();
	//driver.findElement(By.id("description")).sendKeys("debt payoff");
	//driver.findElement(By.id("amount")).sendKeys("$30,000");
	//driver.findElement(By.id("submit")).click();
	By verifydeposit= By.linkText("debt payoff");
	
	verifywebelement(driver, 10,verifydeposit);
	
	
//driver.close();
//driver.quit();
			
	
	
	
}
private void verifywebelement(WebDriver driver, int i, By by ) {
	WebDriverWait wait= new WebDriverWait(driver,i);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
}	
}
