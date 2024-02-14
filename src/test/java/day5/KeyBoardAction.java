package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement inputText = driver.findElement(By.id("name"));
		inputText.sendKeys("Welcome to Automation");
		Actions ac = new Actions(driver);

		ac.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		ac.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		ac.sendKeys(Keys.TAB).perform();
		ac.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		//ac.sendKeys(Keys.TAB).perform();
		ac.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		ac.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		ac.sendKeys(Keys.TAB).perform();
		ac.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();




	}

}
