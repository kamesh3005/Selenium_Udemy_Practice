package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSliderElement {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement slider = driver.findElement(By.xpath("//span[1]"));
		WebElement slider_max = driver.findElement(By.xpath("//span[2]"));


		Actions ac = new Actions(driver);
		System.out.println("current location of the main slider :" + slider.getLocation());

		ac.dragAndDropBy(slider, 100, 250).perform();
		System.out.println("current location of the second slider :" + slider.getLocation());

		ac.dragAndDropBy(slider_max, -100, 250).perform();

	}

}
