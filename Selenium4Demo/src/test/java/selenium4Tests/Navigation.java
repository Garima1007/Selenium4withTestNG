package selenium4Tests;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

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
	public void navigate() {
		driver.get("https://automationstepbystep.com/");
		
		driver.findElement(By.id("menu-item-86")).click();
		
		driver.navigate().back();
		driver.navigate().forward();
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	
	}

}
