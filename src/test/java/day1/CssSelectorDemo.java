package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[type='text'][id='small-searchterms']")).sendKeys("Apple");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		driver.findElement(By.cssSelector("[alt='Picture of Apple MacBook Pro 13-inch']")).click();
		String text = driver.findElement(By.cssSelector("div[class='short-description'] ")).getText();
		System.out.println(text);
		driver.findElement(By.cssSelector("button[id*='-cart']")).click();
		Thread.sleep(3000);
		String message = driver.findElement(By.cssSelector("p[class='content']")).getText();
		System.out.println(message);
		// driver.close();

	}

}
