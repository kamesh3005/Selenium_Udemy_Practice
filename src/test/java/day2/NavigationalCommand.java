package day2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommand {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(url);// we can pass both url type and string type
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.get(url);// in get method we can only pass the string type url

	}

}
