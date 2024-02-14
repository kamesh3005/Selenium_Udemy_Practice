package day9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingExcel {
	WebDriver driver;

	@BeforeClass

	void lauchDriver() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass

	void tearDown() {

		driver.close();
	}

	@Test(dataProvider = "login")

	void loginTest(String uname, String pass, String exp) {
		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.clear();
		email.sendKeys(uname);
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.clear();
		password.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expec_title = "Dashboard / nopCommerce administration";
		String act_title = driver.getTitle();

		if (exp.equals("Valid")) {

			if (expec_title.equals(act_title)) {

				driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
				AssertJUnit.assertTrue(true);
			} else {

				AssertJUnit.fail();

			}

		} else if (exp.equals("Invalid")) {
			if (expec_title.equals(act_title)) {
				driver.findElement(By.linkText("Logout")).click();
				AssertJUnit.assertTrue(false);
			} else {
				AssertJUnit.assertTrue(true);
			}
		}

	}

	@DataProvider(name = "login")
	public String[][] getData() throws IOException {

		/*
		 * String loginData[][]= {
		 * 
		 * {"admin@yourstore.com","admin","Valid"},
		 * {"admin@yourstore.com","admi","Invalid"},
		 * {"admin@yourstore.com","admin123","Invalid"},
		 * {"admin@yourstore.com","admin","Valid"}
		 * 
		 * 
		 * };
		 */
		// get the data from excel
		String loc = System.getProperty("user.dir") + "/testData/NoncommersStore.xlsx";
		ExcelUtil exl = new ExcelUtil(loc);
		int totalRows = exl.getRowCount("Sheet1");
		int totalCells = exl.getCellCount("Sheet1", 1);
		String loginData[][] = new String[totalRows][totalCells];
		for (int r = 1; r <= totalRows; r++) {

			for (int c = 0; c < totalCells; c++) {

				loginData[r - 1][c] = exl.getCellData("Sheet1", r, c);
			}

		}

		return loginData;
	}

}
