package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		List<WebElement> str = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]/li/a"));
		for (WebElement s : str) {
			String text = s.getText();
			if (text.equals("Books")) {
				System.out.println(text);
			}

		}
		driver.findElement(By.xpath("//a/img[@alt='nopCommerce demo store']")).click();
	}

}
