package day5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScrollPageByJS {

	public static void main(String[] args) throws InterruptedException {
		

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// 1.scroll page by pixel
		JavascriptExecutor js = driver;
		// js.executeScript("window.scrollBy(0,3000)", "");
		// System.out.println(js.executeScript("return window.pageYOffset;"));

		// List<WebElement> allflage = driver
		// .findElements(By.xpath("//div[@class='container']/descendant::tbody/tr/td[2]"));
		// int size = allflage.size();
		// System.out.println(size);

		// for (WebElement all : allflage) {

		// if (all.getText().startsWith("B")) {

		// System.out.println(all.getText());
		// }

		// }

		// 2.scroll down the page till the element is visible

		// WebElement flages =
		// driver.findElement(By.xpath("//td[normalize-space()='Zimbabwe']"));
		// js.executeScript("arguments[0].scrollIntoView();", flages);
		// System.out.println(js.executeScript("return window.pageYOffset;"));

		// 3. scroll down till end of the page/document
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(4000);
		//4.go back to the initial position
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");


	}

}
