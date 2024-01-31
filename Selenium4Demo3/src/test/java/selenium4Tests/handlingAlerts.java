package selenium4Tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class handlingAlerts {

	WebDriver driver = null;
	
	
	@BeforeTest
	public void setUp() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test
	public void alerts() {
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		if(driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("alert1 test passed");
		}

		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.alertIsPresent());
		Alert alert2= driver.switchTo().alert();
		alert2.accept();

		if(driver.getPageSource().contains("You clicked: Ok")) {
			System.out.println("alert2 test passed");
		}

		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Wait<WebDriver> wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.alertIsPresent());
		Alert alert3 = driver.switchTo().alert();
		alert3.dismiss();

		if(driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("alert3 test passed");
		}

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Wait<WebDriver> wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait4.until(ExpectedConditions.alertIsPresent());
		Alert alert4 = driver.switchTo().alert();
		alert4.dismiss();

		if (driver.getPageSource().contains("You entered: null")) {
			System.out.println("alert4 test passed");
		}

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Wait<WebDriver> wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait5.until(ExpectedConditions.alertIsPresent());
		Alert alert5 = driver.switchTo().alert();
		alert5.sendKeys("fdfdfdfe");
		alert5.accept();

		if (driver.getPageSource().contains("You entered: fdfdfdfe")) {
			System.out.println("alert5 test passed");
		}

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Wait<WebDriver> wait6 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait6.until(ExpectedConditions.alertIsPresent());
		Alert alert6 = driver.switchTo().alert();
		alert6.accept();

		if (driver.getPageSource().contains("You entered: ")) {
			System.out.println("alert6 test passed");
		}

	}

	@AfterTest
	public void teadDown() {
		driver.close();
		driver.quit();
	}


}
