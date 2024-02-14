package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		driver.findElement(By.name("submit_search")).click();
		// driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
		driver.findElement(By.partialLinkText("Short Sleeve")).click();

	}

}
