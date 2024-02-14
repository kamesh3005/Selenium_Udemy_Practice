package day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPractics {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.findElement(By.xpath("//button[starts-with(text(),'Aler')]")).click();
		// driver.findElement(By.cssSelector("button[onclick='myFunctionPrompt()']")).click();
		driver.findElement(By.xpath("//button[@onclick='myFunctionPrompt()']")).click();
		Alert alert = driver.switchTo().alert();
		// Alert until = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.sendKeys("kamesh");
		Thread.sleep(3000);
		alert.accept();
		String actulResult = "Hello kamesh! How are you today?";
		String expectedResult = driver.findElement(By.xpath("//p[@id='demo']")).getText();

		if (expectedResult.equals(actulResult)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");

		}
	}

}
