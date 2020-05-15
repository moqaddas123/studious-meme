package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PracticeHandle {
WebDriver driver ;
		@Test
      public void practiceHandle() throws InterruptedException {
    	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	  driver = new ChromeDriver();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		System.out.println(driver.getTitle());
    		driver.get("https://www.yahoo.com/");
    		driver.findElement(By.id("header-search-input")).sendKeys("xpath");
    		driver.findElement(By.id("header-desktop-search-button")).click();
    		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
    		System.out.println(driver.getWindowHandles());
    		
    		for(String windowHandle :(driver.getWindowHandles())) {
    			driver.switchTo().window(windowHandle);
    		}
    		Thread.sleep(3000);
    		driver.findElement(By.linkText("SQL")).click();
    		
    		waitForElement(driver ,40 ,By.xpath("//span[contains(text(),'Tutorial')]"));
    		Thread.sleep(3000);
    		driver.close();
    		driver.quit();
    	  
      }
      private void waitForElement(WebDriver driver , int timeToWaitInSeconds ,By ElementLocator) {
    		WebDriverWait wait = new WebDriverWait(driver,10);
    		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));
    	} 
}
