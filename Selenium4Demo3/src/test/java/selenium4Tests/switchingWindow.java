package selenium4Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchingWindow {

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
	public void switchWindow() throws InterruptedException {
		driver.get("https://automationstepbystep.com/");
		String parentWindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		String childWindow = driver.getWindowHandle();
		
		driver.switchTo().window(parentWindow);
		driver.switchTo().window(childWindow);
		
		Thread.sleep(3000);
		
	}
		
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
