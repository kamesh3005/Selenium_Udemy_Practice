package day2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		// Get the title of the page

		String title = driver.getTitle();
		System.out.println("Title of the webPage :" + title);
		// Get the current Url of the page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL :" + currentUrl);

		String pageSource = driver.getPageSource(); //
		System.out.println(pageSource);

		System.out.println("Window ID: " + driver.getWindowHandle());
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

		Set<String> wind = driver.getWindowHandles();
		for (String w : wind) {

			System.out.println(w);
		}

	}

}
