package selenium4Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchingTabs {

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
	public void switchTab() throws InterruptedException {
		
		driver.get("https://automationstepbystep.com/");
		String parentWindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.linkedin.com/feed/");
		String childWindow = driver.getWindowHandle();
		
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		driver.switchTo().window(childWindow);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver.quit();
		
	}

}
