package day8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MySecondTest {
	WebDriver driver;

	@BeforeClass
	// @Test(priority = -202)
	public void launchBrowser() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test

	public void login() {

		driver.findElement(By.xpath("//input[contains(@name,'usern')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@AfterClass
	// @Test(priority = -50)
	public void closeBrowser() {

		driver.close();
	}
}
