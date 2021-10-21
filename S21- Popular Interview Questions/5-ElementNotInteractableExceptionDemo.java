package interviewquestions;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotInteractableExceptionDemo {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get("https://courses.letskodeit.com/login");
		driver.findElement(By.xpath("//form[@action='/login']")).click();
		driver.findElement(By.xpath("//form[@action='/login']")).sendKeys("abc");
		driver.findElement(By.xpath("//h4[@class='dynamic-heading']")).sendKeys("abc");
		
		driver.get("https://courses.letskodeit.com/courses");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Test");		
	}
	
	@Test
	public void test2() throws InterruptedException {
		driver.get("https://www.expedia.com/");
		driver.findElement(By.xpath("//a[@aria-controls='wizard-flight-pwa']")).click();
		//driver.findElement(By.id("location-field-leg1-origin-input")).sendKeys("SFO");
		driver.findElement(By.xpath("//button[@data-stid='location-field-leg1-origin-menu-trigger']")).click();
		driver.findElement(By.id("location-field-leg1-origin")).sendKeys("SFO");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}
}