package selenium4Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingLists {

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
	public void lists() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.findElement(By.id("checkboxes"));
		WebElement list = driver.findElement(By.id("checkboxes"));
		String options = list.getText();
		System.out.println(options);
		
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
