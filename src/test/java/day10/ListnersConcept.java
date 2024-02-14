package day10;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.awt.AWTException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(day10.ExtentReportManager.class)
public class ListnersConcept {
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
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@Test(priority = 2)
	void adminTest() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::ul/li/a//span[text()='Admin']"))
				.click();

		driver.findElement(
				By.xpath("//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--secondary']"))
				.click();

		driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[1]")).click();

		Actions ac1 = new Actions(driver);
		ac1.sendKeys(Keys.ARROW_DOWN).perform();
		ac1.sendKeys(Keys.ARROW_DOWN).perform();
		ac1.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("s");
		Thread.sleep(5000);

		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).perform();
		ac.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[2]")).click();
		Actions ac2 = new Actions(driver);
		ac2.sendKeys(Keys.ARROW_DOWN).perform();
		ac2.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath(
				"(//div[@class='oxd-input-group oxd-input-field-bottom-space']/following::input[@class='oxd-input oxd-input--active'])[1]"))
				.sendKeys("kameshcharu");
		driver.findElement(By.xpath(
				"//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']"))
				.sendKeys("Kamesh@1234");
		driver.findElement(By.xpath(
				"(//div[@class='oxd-input-group oxd-input-field-bottom-space']/following::input[@class='oxd-input oxd-input--active'])[2]"))
				.sendKeys("Kamesh@1234");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3, dependsOnMethods = { "login", "adminTest" })
	void searchUser() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input"))
				.sendKeys("kameshcharu");
		driver.findElement(
				By.xpath("(//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/div/div/div)[2]"))
				.click();
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.DOWN).perform();
		ac.sendKeys(Keys.DOWN).perform();
		ac.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(2000);
		try {
			driver.findElement(By.xpath(
					"//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"))
					.click();
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
		} catch (Exception e) {

		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();

	}

	@Test(priority = 4, dependsOnMethods = { "login" })
	void logoutTest() {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

		boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
		AssertJUnit.assertEquals(logo, true);

	}

}
