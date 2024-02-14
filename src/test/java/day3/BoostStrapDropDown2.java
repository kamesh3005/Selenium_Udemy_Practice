package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostStrapDropDown2 {

	public static void main(String[] args) {
		String text = null;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("java");

		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='Alh6id']/descendant::ul/li"));
		System.out.println(ele.size());

		for (int i = 0; i < ele.size(); i++) {
			System.out.println(ele.get(i).getText());
			try {
				text = ele.get(i).getText();

				if (text.equals("java jdk download")) {

					ele.get(i).click();
				}

			} catch (Exception e) {
			}

		}

	}

}
