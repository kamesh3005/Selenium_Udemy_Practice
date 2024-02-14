package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.id("input-username")).sendKeys("demo");
		driver.findElement(By.id("input-password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		boolean dis = driver.findElement(By.xpath("//button[@type='button'and @class='btn-close']")).isDisplayed();
		if (dis == true) {
			driver.findElement(By.xpath("//button[@type='button'and @class='btn-close']")).click();

		}
		driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
		driver.findElement(By.xpath("//li[@id='menu-customer']/descendant::li/a[text()='Customers']")).click();
		String text = driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 10 of 16198 (1620 Pages)')]"))
				.getText();
		int total = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println(total);

	}

}
