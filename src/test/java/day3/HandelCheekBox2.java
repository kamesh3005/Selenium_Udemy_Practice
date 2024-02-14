package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelCheekBox2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		List<WebElement> days = driver.findElements(By.xpath("(//div[@class='form-group'])[4]/descendant::label"));
		/*
		 * for (WebElement day : days) {
		 * 
		 * System.out.println(day.getText()); }
		 */

		for (int i = 5; i < days.size(); i++) {

			days.get(i).click();

		}
	}
}
