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

public class iFramesHandling {

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
	public void iFrames() throws InterruptedException {
		driver.get("https://www.linkedin.com");
		driver.findElement(By.name("session_key")).sendKeys("sharma.garima1007@gmail.com");
		driver.findElement(By.name("session_password")).sendKeys("Minnie@2024");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body[1]/div[4]/div[4]/aside[1]/div[1]/header[1]/div[3]/button[2]")).click();
		Thread.sleep(1000);
		
		WebElement iFrame = driver.findElement(By.className("ad-banner"));
		driver.switchTo().frame(iFrame);
		
		
	}
	
	@AfterTest
	public void tearDown() {	
		driver.close();
		driver.quit();
		
	}

}
