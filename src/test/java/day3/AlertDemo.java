package day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

		Alert alert = driver.switchTo().alert();

		Alert until = mywait.until(ExpectedConditions.alertIsPresent());

		System.out.println(until.getText());
		//until.accept();
		until.dismiss();

	}

}
