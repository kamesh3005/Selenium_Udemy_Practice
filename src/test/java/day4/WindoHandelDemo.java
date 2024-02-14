package day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindoHandelDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@id='button1'and contains(text(),'New Browser Window')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> window = new ArrayList<String>(windowHandles);
		String parentWindow = window.get(0);
		String child = window.get(1);
		driver.switchTo().window(child);
		driver.manage().window().maximize();

		String text = driver.findElement(By.xpath("//h2[contains(text(),'Most Affordable Selenium Online Course')]"))
				.getText();

		System.out.println(text);
		WebElement course = driver.findElement(By.xpath("(//a[text()='Course Offered'])[2]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(course).perform();
		List<WebElement> allElement = driver.findElements(
				By.xpath("(//ul[@class='header-menu clearfix'])[2]//li[2]//ul[@class='sub-menu']//li//a"));

		System.out.println(allElement.size());

		for (WebElement ele : allElement) {

			System.out.println(ele.getText());
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();

		Set<String> windowHandles2 = driver.getWindowHandles();
		Iterator<String> itr = windowHandles2.iterator();
		String par2 = itr.next();
		String child2 = itr.next();
		driver.switchTo().window(child2);

		WebElement automation = driver.findElement(By.xpath(

				"(//li[@class='menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-7004']//a[text()='Free Automation Courses'])[2]"));
		WebElement freeCourse = driver.findElement(By.xpath(
				"//div[@class='collapse navbar-collapse pull-right']//a[contains(text(),'Free YouTube Courses')]"));
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(automation).moveToElement(freeCourse).click().perform();

		List<WebElement> allManualTesting = driver.findElements(By.xpath(
				"(//div[@class='header_main_menu_wrapper clearfix']/descendant::div/descendant::ul/li)[20]/ul/li/descendant::ul/li/a"));

		for (WebElement all : allManualTesting) {

			System.out.println(all.getText());
		}

		Thread.sleep(5000);
		driver.close();

		driver.switchTo().window(par2);
		driver.close();

	}

}
