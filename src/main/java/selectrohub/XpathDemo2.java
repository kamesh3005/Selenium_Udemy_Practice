package selectrohub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathDemo2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://demowebshop.tricentis.com");
		List<WebElement> slider = driver.findElements(By.xpath("//div[@id='nivo-slider']//a//img"));
		System.out.println(slider.size());

		List<WebElement> ele = driver
				.findElements(By.xpath("//div[@id='nivo-slider']//a[contains(@href,'tricentis.com')]"));

		for (WebElement e : ele) {
			String attribute = e.getAttribute("href");
			System.out.println(attribute);
		}

		List<WebElement> allList = driver.findElements(By.xpath("(//ul)[8]//li//a"));

		for (WebElement all : allList) {

			String text = all.getAttribute("href");
			System.out.println(text);
		}

	}

}
