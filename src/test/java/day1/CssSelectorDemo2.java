package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		String txt = driver.findElement(By.xpath("//div[text()='Log in to Facebook']")).getText();
		System.out.println(txt);
		driver.findElement(By.xpath("//div[@class='_xkv fsm fwn fcg' ]/a[text()='Forgotten account?']")).click();
		String str = driver.findElement(By.xpath("//div[@class='_9nq2 marginBottom16px']")).getText();

		System.out.println(str);

	}

}
