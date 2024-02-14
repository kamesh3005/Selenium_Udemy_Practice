package day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDatePickUp {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#DropDown%20DatePicker");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement da = driver.findElement(By.xpath("//li[@id='DropDown DatePicker']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','kamesh')", da);
		driver.switchTo().frame(driver.findElement(By.xpath(
				"//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']")));

		String year = "2023";
		String month = "May";
		String date = "30";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		Select sc = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		sc.selectByVisibleText("May");
		Select sc1 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		sc.selectByVisibleText("2024");

	}

}
