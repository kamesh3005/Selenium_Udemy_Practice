package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelDynamicwebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// find the Size of rows and columns
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Size of the row :" + rows);
		int coloum = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Size of coloum is :" + coloum);

		for (int r = 2; r <= rows; r++) {

			String subject = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[3]")).getText();
			// System.out.println(subject);

			if (subject.equals("Selenium")) {
				String auth = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]"))
						.getText();
				System.out.println(auth + "  " + subject);

			}

		}

		// To find the total sum of the book:
		int sum = 0;
		for (int i = 2; i < rows; i++) {

			WebElement price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[4]"));
			String pric = price.getText();
			sum = sum + Integer.parseInt(pric);

		}
		System.out.println("Total sum: " + sum);

	}

}
