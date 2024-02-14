package day2;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		FluentWait<WebDriver> mywait = new FluentWait<WebDriver>(driver);
		mywait.withTimeout(Duration.ofSeconds(30));
		mywait.pollingEvery(Duration.ofSeconds(5));
		mywait.ignoring(NoSuchElementException.class);

		WebElement username = (WebElement) mywait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		WebElement pass = (WebElement) mywait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='password']")));
		username.sendKeys("Admin");
		pass.sendKeys("admin123");
		// driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		// driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
