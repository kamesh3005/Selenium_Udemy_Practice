package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(
				"//a[contains(@href,'login?return')]/ancestor::ul/child::li/a[contains(@href,'/wishli')]/span[starts-with(text(),'Wishli')]"))
				.click();
		String str = driver.findElement(By.xpath("//div[@class='page-body']/child::div")).getText();

		System.out.println(str);
		WebElement ele = driver.findElement(By.xpath(
				"//div[@class='header-links']/child::ul/following::div[@class='search-box store-search-box']/child::form/input"));

		ele.sendKeys("Apple macbook");
		driver.findElement(By.xpath("(//*[contains(text(),'Search')and @type='submit'])[1]")).click();

	}

}
