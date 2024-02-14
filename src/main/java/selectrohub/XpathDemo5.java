package selectrohub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo5 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://selectorshub.com");

		driver.findElement(By.xpath("//li[@id='menu-item-1075']/a/following::a[.='PracticePage']")).click();

		driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr[1]/td/input")).click();

		List<WebElement> allTable = driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr/td[2]/a"));

		for (int i = 0; i < allTable.size(); i++) {

			String webElement = allTable.get(i).getText();
			System.out.println(webElement);
		}
	}

}
