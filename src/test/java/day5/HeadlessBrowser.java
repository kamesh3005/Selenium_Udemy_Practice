package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HeadlessBrowser {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		//opt.setHeadless(true);

		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("//input[starts-with(@name,'usernam')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[starts-with(@name,'password')]")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		WebElement logo = driver.findElement(By.xpath("//img[contains(@src,'/orangehrm-logo.png')]"));
		if (logo.isDisplayed()) {

			System.out.println("Login Successfull");
		} else {

			System.out.println("Login Fail");
		}

	}

}
