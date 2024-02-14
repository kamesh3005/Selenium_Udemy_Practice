package day6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickup {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		// Approch 1
		// driver.findElement(By.id("datepicker")).sendKeys("10/13/2023");

		// Approch 2
		String year = "2022";
		String month = "May";
		String date = "30";
		driver.findElement(By.id("datepicker")).click();
		// 1.selecting month and year
		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yer = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (mon.equals(month) && yer.equals(year)) {
				break;

			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//future Date 
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); past Date
		}

		// 2.Selecting the Date
		List<WebElement> allDate = driver
				.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//td"));
		for (WebElement d : allDate) {
			if (d.getText().equals(date)) {

				d.click();
				break;
			}

		}

	}

}
