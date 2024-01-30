package selenium4Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingDropdowns {

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
	public void dropDowns( ) {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		dropdown.click();
		Select option = new Select(dropdown);
		option.selectByIndex(1);
		option.selectByIndex(2);

	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
