package selectrohub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://money.rediff.com/gainers/bse/daily/groupa");

		List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr//td[1]"));
		for (int i = allElement.size()-1; i > 0; i--) {

			String text = allElement.get(i).getText();
			System.out.println(text);

		}

	}
}
