package day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTable {

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

		// String text =
		// driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[1]")).getText();
		System.out.println("****************************");
		// System.out.println(text);
		// Print the row and coloum
		for (int r = 2; r <= rows; r++) {
			for (int c = 1; c <= coloum; c++) {
				String text = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(text + "|");

			}
			System.out.println();

		}
		// Printing the book name whose author is Amit
		System.out.println("*************************************");

		for (int r = 2; r <= rows; r++) {

			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[3]"))
					.getText();
			System.out.println(authorName);

			if (authorName.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]"))
						.getText();

				System.out.println(authorName + " " + bookName);

			}

		}
	}

}
