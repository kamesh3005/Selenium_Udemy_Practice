package day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelTheCheekBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@type='button']/child::span")).click();

		List<WebElement> ele = driver.findElements(
				By.xpath("//ul[@class='multiselect-container dropdown-menu']/descendant::a/child::label"));
		System.out.println(ele.size());

		/*
		 * for (int i = 0; i < ele.size(); i++) {
		 * System.out.println(ele.get(i).getText());
		 * 
		 * }
		 */

		for (WebElement element : ele) {

			String text = element.getText();

			if (text.equals("MySQL") || text.equalsIgnoreCase("python")) {

				element.click();
			}
		}

	}

}
