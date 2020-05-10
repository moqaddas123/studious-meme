package assignment1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice123 {

   WebDriver driver;

@Before
	public void LaunchBrowser() {	
	
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver 2");
		driver= new ChromeDriver();
		driver.manage().window().maximize();				
		

	}
@Test
	public void Login() throws InterruptedException {
		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		String expectedtitle= "Welcome: Mercury Tours";
		String actualtitle = driver.getTitle();
		
		if(expectedtitle.equalsIgnoreCase(actualtitle)) {
			System.out.println(" Test Passed! " + " Titles Matched ");
		}else System.out.println("Test Failed. Titles did not match ");
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		Thread.sleep(500);
		Boolean button1 = driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();
		
		if(button1 ==true) {
			System.out.println("Sign off button is displayed. ");
		}else System.out.println("no sign off button");
	}
@After
	public void teardown() {
		
	driver.close();
	driver.quit();
	}

}
