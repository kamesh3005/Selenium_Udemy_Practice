package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement frame1 = driver.findElement(By.xpath("//*[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("kamesh");

		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[contains(@src,'frame_3')]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//div[@align='center']//input")).sendKeys("CharuMathi");
		
		//WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src,'viewform?embedded')]"));
		//driver.switchTo().frame(iframe);
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'frame_4')]")));
		
		
		
		
	}

}
