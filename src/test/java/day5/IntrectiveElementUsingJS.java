package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntrectiveElementUsingJS {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		// inputbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','kamesh')", name);
		js.executeScript("arguments[0].setAttribute('value','kameshkam3094@gmail.com')", email);
		
		//Radio Button
		WebElement male_butt = driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click(); ", male_butt);
		//Checkbox
		WebElement newWindow = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		js.executeScript("arguments[0].click();", newWindow);

	}

}
