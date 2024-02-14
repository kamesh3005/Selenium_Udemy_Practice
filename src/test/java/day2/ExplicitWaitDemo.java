package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement uname = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		WebElement umane=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		umane.sendKeys("Admin");

		//WebElement pass = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		WebElement pass=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
		pass.sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
