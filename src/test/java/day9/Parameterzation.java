package day9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Parameterzation {
	WebDriver driver;

	@BeforeClass

	void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterClass

	void tearDown() {

		driver.close();
	}

	@Test(priority = 1)
	@Parameters({ "username", "password" })

	void logingTest(String uname, String pass) {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority = 2)

	void titleTest() {

		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title is not matched");
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}

	@Test(priority = 3)
	void logout() {

		boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
		Assert.assertTrue(logo);
		WebElement loin = driver
				.findElement(By.xpath("//div[@class='orangehrm-login-logo-mobile']/following-sibling::h5"));
		System.out.println(loin.getText());
	}

}
