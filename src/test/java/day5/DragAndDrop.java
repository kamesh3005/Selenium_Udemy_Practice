package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Actions ac = new Actions(driver);

		WebElement madrid = driver.findElement(By.xpath("(//div[@id='dropContent']//div[text()='Madrid'])[2]"));
		WebElement spain = driver.findElement(By.xpath("//div[@id='countries']//div[text()='Spain']"));
		ac.dragAndDrop(madrid, spain).perform();

		WebElement washington = driver.findElement(By.xpath("(//div[@id='dropContent']//div[text()='Washington'])[2]"));
		WebElement usa = driver.findElement(By.xpath("//div[@id='countries']//div[text()='United States']"));

		ac.dragAndDrop(washington, usa).perform();

	}

}
