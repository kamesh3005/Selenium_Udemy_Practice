package day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShort {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// Taking full page screen short
		// TakesScreenshot ts = (TakesScreenshot) driver;
		// File src = ts.getScreenshotAs(OutputType.FILE);
		// File trg = new
		// File("/home/kamesh/eclipse-workspace/SeleniumUdemyPractices/ScreenShort/fullpage.png");
		// FileUtils.copyFile(src, trg);

		// Taking screenshort specific area of the webpage

		WebElement frature = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File scr = frature.getScreenshotAs(OutputType.FILE);
		File dec = new File("/home/kamesh/eclipse-workspace/SeleniumUdemyPractices/ScreenShort/feature.png");
		FileUtils.copyFile(scr, dec);

		WebElement logo = driver.findElement(By.xpath("//img[contains(@alt,'nopCommerce demo')]"));
		File src1 = logo.getScreenshotAs(OutputType.FILE);
		File f = new File("/home/kamesh/eclipse-workspace/SeleniumUdemyPractices/ScreenShort/logo.png");
		FileUtils.copyFile(src1, f);
	}

}
