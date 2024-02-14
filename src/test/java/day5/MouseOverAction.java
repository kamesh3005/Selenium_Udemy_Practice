package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverAction {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement computer = driver.findElement((By.xpath("(//div[@class='header-menu']//ul/li//a)[2]")));
		WebElement noteBook = driver.findElement(By.xpath("(//div[@class='header-menu']//ul/li//a)[4]"));
		Actions ac = new Actions(driver);

		ac.moveToElement(computer).moveToElement(noteBook).click().perform();

	}

}
