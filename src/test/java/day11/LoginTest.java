package day11;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(day10.ExtentReportManager.class)
public class LoginTest {
	WebDriver driver;
	LoginPage2 lp;
	// LoginPage lp;

	@BeforeClass

	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

	}

	@AfterClass

	void tearDown() {

		driver.close();
	}

	@Test(priority = 1)

	void testLogo() {
		lp = new LoginPage2(driver);
		// lp = new LoginPage(driver);

		Assert.assertEquals(lp.cheeckLogoPresent(), true);

	}

	@Test(priority = 2)
	void testLogin() {
		// lp = new LoginPage(driver);
		lp = new LoginPage2(driver);
		lp.setUserName("admin@yourstore.com");
		lp.setPassword("admin");
		lp.clickSubmit();

		Assert.assertEquals(lp.cheeckHomePageLogo(), true);
	}

	@Test(priority = 3, dependsOnMethods = { "testLogin" })

	void testLogout() {
		// lp = new LoginPage(driver);
		lp = new LoginPage2(driver);

		lp.setLogout();
		Assert.assertEquals(driver.getTitle(), "Your store. Login");

	}

}
