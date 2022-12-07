package waittypes;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"/Users/atomar/Documents/workspace_personal/libs/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
	}
	
	@Test()
	public void test() throws Exception {
		driver.get(baseUrl);
		WebElement loginLink = driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]"));
		loginLink.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement emailField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailField.sendKeys("test");
		
		// driver.findElement(By.id("user_email")).sendKeys("test");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
