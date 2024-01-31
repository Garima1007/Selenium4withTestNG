package selenium4Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

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
	public void takeScreenshot() throws IOException {
		driver.get("https://automationstepbystep.com/");
		
		File scr1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr1, new File("./image.png"));
		
		driver.findElement(By.id("menu-item-89")).click();
		
		File scr2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr2, new File("./image1.png"));

		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
