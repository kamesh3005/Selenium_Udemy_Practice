package day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement countryList = driver.findElement(By.id("country-list"));
		Select sc = new Select(countryList);
		// sc.selectByVisibleText("India");
		// sc.selectByIndex(3);
		// sc.selectByValue("5");
		List<WebElement> allList = sc.getOptions();
		System.out.println(allList.size());

		for (int i = 0; i < allList.size(); i++) {

			System.out.println(allList.get(i).getText());
		}

	}

}
