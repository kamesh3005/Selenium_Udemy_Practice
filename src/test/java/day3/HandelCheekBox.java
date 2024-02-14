package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelCheekBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/radio.html");
		List<WebElement> allele = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(allele.size());
		/*
		 * for (WebElement all : allele) {
		 * 
		 * all.click(); }
		 */

		for (int i = 0; i <=2; i++) {

			allele.get(i).click();
		}
		Thread.sleep(5000);
		for (int i = 0; i <=2; i++) {

			allele.get(i).click();
		}

	}

}
