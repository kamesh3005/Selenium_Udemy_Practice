package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='header-links']/descendant::li[1]/a")).click();
		boolean logTest = driver.findElement(By.xpath("//div[@class='header-logo']/descendant::img")).isDisplayed();
		System.out.println(logTest);

		WebElement searchBox = driver
				.findElement(By.xpath("//div[@class='search-box store-search-box']/descendant::input"));
		boolean enabled = searchBox.isEnabled();
		System.out.println("Search Box is enanle :" + enabled);
		boolean displayed = searchBox.isDisplayed();
		System.out.println("search box is diplay or nor :" + displayed);
		WebElement maleRadiobutton = driver.findElement(By.id("gender-male"));
		WebElement femaleRadiobutton = driver.findElement(By.id("gender-female"));

		// before selection of radio button

		System.out.println(maleRadiobutton.isSelected());
		System.out.println(femaleRadiobutton.isSelected());
		// After selection of Radio button
		femaleRadiobutton.click();
		// maleRadiobutton.click();

		System.out.println(maleRadiobutton.isSelected());
		System.out.println(femaleRadiobutton.isSelected());

	}

}
