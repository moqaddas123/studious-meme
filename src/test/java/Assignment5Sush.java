import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment5Sush {
	WebDriver driver;
	By usernameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//div[@class='sign-in-inner']/descendant::button[@type='submit']");
	By bankAndCashNavigator = By.xpath("//span[contains(text(),'Bank & Cash')]");
	By newAcoountLocator = By.xpath("//a[text()='New Account']");
	By accountTitleField = By.id("account");
	By descriptionField = By.name("description");
	By initialBalanceField = By.xpath("//input[@class='form-control amount']");
	By submitButton = By.xpath("//form[@role='form']/descendant::button[@type='submit']");
	By accountCreatedSuccessMsg = By.xpath("//div[@class='alert alert-success fade in']");
	By transactionsLocator = By.xpath("//span[contains(text(),'Transactions')]");
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\visha\\SeleniumWinter2020\\studious-meme\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
	}

	@Test
	public void addAccount() throws InterruptedException {

		driver.findElement(usernameField).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(passwordField).sendKeys("abc123");
		driver.findElement(signInButton).click();
		Thread.sleep(3000);
		driver.findElement(bankAndCashNavigator).click();
		driver.findElement(newAcoountLocator).click();
		Random rnd = new Random();
		int randomNo = rnd.nextInt(999);
		driver.findElement(accountTitleField).sendKeys("MOM :" + randomNo);
		driver.findElement(descriptionField).sendKeys("Mother's Day :" + randomNo);
		driver.findElement(initialBalanceField).sendKeys("100");
		driver.findElement(submitButton).click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("Scroll(0, 2000)");
		scrollDown(driver);
		Thread.sleep(2000);
		scrollUp(driver);
		//js.executeScript("Scroll(2000 ,0)");
		Assert.assertTrue(driver.findElement(accountCreatedSuccessMsg).isDisplayed(), "Account Not Created!!");
		
		driver.findElement(transactionsLocator).click();
		
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	private void scrollUp(WebDriver a) {
		((JavascriptExecutor)a).executeScript("scroll(2000,0)");
		
	}

	private void scrollDown(WebDriver a) {
		JavascriptExecutor js = (JavascriptExecutor) a;
		js.executeScript("scroll( 0,2000)");

	}

}
