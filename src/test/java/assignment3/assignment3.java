package assignment3;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class assignment3 {

@Test
public void practice3() {
	System.setProperty("webdriver.gecko.driver", "./firefoxdriver/geckodriver");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://techfios.com/test/billing/?ng=admin/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("techfiosdemo@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
	driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	driver.findElement(By.linkText("Transactions")).click();
	driver.findElement(By.linkText("Transfer")).click();
	//driver.findElement(By.id("select2-faccount-container")).click();
	//driver.findElement(By.xpath("//ul[@class='select2-results__options']/child::li[5]")).click();
	//driver.findElement(By.id("select2-taccount-container")).click();
	//driver.findElement(By.xpath("//ul[@class='select2-results__options']/child::li[6]")).click();
	//driver.findElement(By.id("description")).sendKeys("savings");
	//driver.findElement(By.id("amount")).sendKeys("1000");
	//driver.findElement(By.id("submit")).click();
	By verifysavings = By.linkText("savings");
	
	verifywebelement(driver,10,verifysavings);

}
private void verifywebelement(WebDriver driver, int i, By by ) {
	WebDriverWait wait= new WebDriverWait(driver,i);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
}
}