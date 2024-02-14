package day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement color = driver.findElement(By.xpath("//select[@id='colors']"));
		Select sc = new Select(color);
		// sc.selectByIndex(2);
		List<WebElement> allOption = sc.getOptions();
		System.out.println(allOption.size());

		for (int i = 0; i < allOption.size(); i++) {

			String text = allOption.get(i).getText();
			System.out.println(text);
			if (text.equals("Yellow")) {

				allOption.get(i).click();
			}
		}

	}

}
