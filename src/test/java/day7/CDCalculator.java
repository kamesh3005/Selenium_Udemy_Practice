package day7;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

		WebElement Initial_depo = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement lengthOfCd = driver.findElement(By.xpath("(//input[@id='mat-input-1'])[1]"));
		WebElement rateOfIntrest = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement calButton = driver
				.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']"));

		String path = System.getProperty("user.dir") + "/testData/calData2.xlsx";
		int rowCount = ExlUtility.getRowCount(path, "Sheet1");
		// System.out.println(rowCount);

		for (int r = 1; r <= rowCount; r++) {
			// reading data from the excel
			String Deposit_amt = ExlUtility.getCellData(path, "Sheet1", r, 0);
			String len_CD = ExlUtility.getCellData(path, "Sheet1", r, 1);
			String rate_of_Int = ExlUtility.getCellData(path, "Sheet1", r, 2);
			String compoundingMonths = ExlUtility.getCellData(path, "Sheet1", r, 3);
			String exptotal = ExlUtility.getCellData(path, "Sheet1", r, 4);

			// passing value to the application

			Initial_depo.clear();
			lengthOfCd.clear();
			rateOfIntrest.clear();
			Thread.sleep(5000);
			Initial_depo.sendKeys(Deposit_amt);
			lengthOfCd.sendKeys(len_CD);
			rateOfIntrest.sendKeys(rate_of_Int);

			WebElement compounding = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
			compounding.click();
			// Handling dropDown not having select class
			List<WebElement> allCompo = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//span"));

			for (WebElement com : allCompo) {

				if (com.getText().equals(compoundingMonths)) {
					com.click();

				}
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", calButton);
			String actual_result = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();

			if (exptotal.equals(actual_result)) {

				ExlUtility.setCellData(path, "Sheet1", r, 6, "passed");
				ExlUtility.fillGreenColor(path, "Sheet1", r, 6);
			} else {
				ExlUtility.setCellData(path, "Sheet1", r, 6, "failed");
				ExlUtility.fillRedColor(path, "Sheet1", r, 6);

			}
		}

		System.out.println("Calculation had been completed");
		driver.close();

	}

}
