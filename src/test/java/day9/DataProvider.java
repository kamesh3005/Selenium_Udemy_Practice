package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {

	WebDriver driver;

	@BeforeClass

	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeMethod

	void launchUrl() {

		driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

	}

	@Test(dataProvider = "dp")
	void login(String email, String pass) {

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String act_title = "nopCommerce demo store";
		Assert.assertEquals(act_title, driver.getTitle(), "Your password in incorrect");

	}

	@AfterClass
	void tearDown() {

		driver.close();

	}

	@org.testng.annotations.DataProvider(name = "dp")
	Object[][] loginData() {
		Object data[][] = { { "kameshkam3094@gmail.com", "Kamesh@30" }, { "abc@gmail.com", "abc@123" },
				{ "xyz@gmail.com", "xyZ@123" }, { "pqr@gmail.com", "Pqr@145" },
				{ "kameshkam3094@gmail.com", "Kamesh@30" }

		};
		return data;

	}

}
