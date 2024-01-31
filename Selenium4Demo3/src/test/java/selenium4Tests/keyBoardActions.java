package selenium4Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyBoardActions {

	WebDriver driver = null;
	@BeforeTest
	public void setUp() {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test
	public void keyActions() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium" +Keys.ENTER);
		
		Actions actions = new Actions(driver);
		Action keyDown = actions.keyDown(Keys.CONTROL).sendKeys("a").build();
		keyDown.perform();
	
		Thread.sleep(3000);

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
