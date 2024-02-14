package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo2 {

	public static void main(String[] args) {
		// open the application
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
		// find the number of slider in the web page
		List<WebElement> slider = driver.findElements(By.className("homeslider-container"));
		System.out.println("Total Number of slider is :" + slider.size());
		
		// find the total number of image in the web page
		List<WebElement> image = driver.findElements(By.tagName("img"));
		System.out.println("Total number of Image is :" + image.size());

		// find the total number of link in the web page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of link is :" + links.size());
		driver.quit();

	}

}
