package selectrohub;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://demowebshop.tricentis.com");
		driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[contains(@href,'gift-cards')]")).click();
		String attb = driver.findElement(By.xpath("(//div[@class='product-grid']//div[@class='picture'])[1]//a//img"))
				.getAttribute("src");
		System.out.println(attb);

		String name = driver.findElement(By.xpath("//div[@class='block block-manufacturer-navigation']//strong"))
				.getText();

		System.out.println(name);

		driver.findElement(By.xpath(
				"//div[@class='master-wrapper-main']//div[@class='side-2']//div[@class='block block-newsletter']//div//input[@id='newsletter-email']"))
				.sendKeys("ramesh123@gmail.com");

		driver.findElement(By.xpath(
				"//div[@class='master-wrapper-main']//div[@class='side-2']//div[@class='block block-newsletter']//div//input[@id='newsletter-subscribe-button']"))
				.click();

		String emailConformation = driver.findElement(By.xpath("//div[contains(text(),'A verification email has been sent')]")).getText();

		System.out.println(emailConformation);
	}

}
