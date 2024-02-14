package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		// self node
		String str = driver.findElement(By.xpath("//a[contains(@href,'-financial/14011114')]/self::a")).getText();

		System.out.println(str);
		List<WebElement> node = driver
				.findElements(By.xpath("//a[contains(@href,'-financial/14011114')]/ancestor::tr/child::td"));

		System.out.println(node.size());

		for (WebElement n : node) {

			System.out.println(n.getText());
		}
		String str1 = driver
				.findElement(By.xpath(
						"(//a[contains(@href,'-financial/14011114')]/ancestor::tr/preceding-sibling	::tr/td/a)[1]"))
				.getText();
		System.out.println(str1);

		List<WebElement> allele = driver
				.findElements(By.xpath("//a[contains(@href,'-financial/14011114')]/ancestor::tr/parent::*/tr/td/a"));
		for (WebElement all : allele) {

			System.out.println(all.getText());
		}

	}

}
