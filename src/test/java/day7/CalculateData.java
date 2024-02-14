package day7;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculateData {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		String file = System.getProperty("user.dir") + "/testData/calData.xlsx";
		int rowCount = ExlUtility.getRowCount(file, "Sheet1");

		for (int r = 1; r <= rowCount; r++) {

			// read the data from the excel
			String princ = ExlUtility.getCellData(file, "Sheet1", r, 0);
			String RoI = ExlUtility.getCellData(file, "Sheet1", r, 1);
			String per1 = ExlUtility.getCellData(file, "Sheet1", r, 2);
			String per2 = ExlUtility.getCellData(file, "Sheet1", r, 3);
			String fre = ExlUtility.getCellData(file, "Sheet1", r, 4);
			String mut_val = ExlUtility.getCellData(file, "Sheet1", r, 5);

			// pass data to the app
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(RoI);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);

			Select sc = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			sc.selectByVisibleText(per2);
			Select sc1 = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			sc1.selectByVisibleText(fre);

			WebElement cal = driver.findElement(By.xpath("(//a[contains(@href,'javascript:void')]//img)[1]"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", cal);
			// validation & update results in excel
			String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

			if (Double.parseDouble(mut_val) == Double.parseDouble(act_mvalue)) {
				System.out.println("Test Passsed");
				ExlUtility.setCellData(file, "Sheet1", r, 7, "Passed");
				ExlUtility.fillGreenColor(file, "Sheet1", r, 7);
			} else {
				System.out.println("Test Failed");
				ExlUtility.setCellData(file, "Sheet1", r, 7, "Failed");
				ExlUtility.fillRedColor(file, "Sheet1", r, 7);
			}
			Thread.sleep(3000);

			WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clear_btn);

		}
	}

}
