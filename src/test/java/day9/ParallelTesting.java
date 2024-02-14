package day9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTesting {
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	void setup(String br) {
		if (br.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterMethod
	void tearDown() {

		driver.close();
	}

	@Test(priority = 1)
	void logTest() {
		try {
			boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
			AssertJUnit.assertEquals(status, true);
		} catch (Exception e) {
			Assert.fail();

		}

	}

	@Test(priority = 2)
	void titleTest() {

		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM", "title is not match");
		
	}

}
