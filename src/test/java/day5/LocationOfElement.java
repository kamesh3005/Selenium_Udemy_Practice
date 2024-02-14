package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationOfElement {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement loc = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		Point location = loc.getLocation();
		System.out.println("Location of the element Before :" + location);
		driver.manage().window().minimize();
		System.out.println("Location of the element After minimize :" + location);
		driver.manage().window().fullscreen();
		System.out.println("Location of the element After fullscreen :" + location);
		Point p=new Point(100, 200);
		driver.manage().window().setPosition(p);
		System.out.println("Location of the element After setting position :" + location);

		


	}

}
