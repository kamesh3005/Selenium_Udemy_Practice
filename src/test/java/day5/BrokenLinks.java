package day5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println(allLinks.size());

		int brokenLinks = 0;

		for (WebElement link : allLinks) {

			String targetLinks = link.getAttribute("href");

			if (targetLinks == null || targetLinks.isEmpty()) {

				System.out.println("href attribute value is empty.....");
				continue;
			}

			URL linkUrl = new URL(targetLinks);// converting string into url format

			// send request to the server and open connection
			HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
			conn.connect();

			if (conn.getResponseCode() >= 400) {

				System.out.println(targetLinks + "          " + "=====>Broken Link");
				brokenLinks++;
			} else {

				System.out.println(targetLinks + "            " + "===========>Not Broken Link");
			}

		}

	}

}
