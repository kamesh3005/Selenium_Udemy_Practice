package selectrohub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo4 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://selectorshub.com");

		List<WebElement> allEle = driver.findElements(By.xpath("//section[@data-id='2130187']//div[2]/div/h2/a"));
		for (WebElement all : allEle) {

			String text = all.getAttribute("href");
			System.out.println(text);
		}

	}

}
