package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostStrapDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='btn-group']/child::button")).click();
		List<WebElement> allElem = driver
				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/child::li/a/label"));
		System.out.println(allElem.size());

		for (int i = 0; i < allElem.size(); i++) {
			System.out.println(allElem.get(i).getText());

		}

		for (WebElement all : allElem) {
			String text = all.getText();

			if (text.equals("MySQL")) {

				all.click();
				break;
			}
		}

	}

}
