package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	// constructor
	LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// locators
	By img_log_image = By.xpath("//div[@class='page-title']/child::h1");
	By txt_username_loc = By.id("Email");
	By txt_pass_loc = By.id("Password");
	By log_butt = By.xpath("//button[@type='submit']");
	By login_logo = By.xpath("//img[@class='brand-image-xl logo-xl']");
	By logout_butt = By.xpath("//a[normalize-space()='Logout']");

	// Action Method

	public void setUserName(String username) {

		WebElement uname = driver.findElement(txt_username_loc);
		uname.clear();
		uname.sendKeys(username);

	}

	public void setPassword(String password) {
		WebElement pass = driver.findElement(txt_pass_loc);
		pass.clear();
		pass.sendKeys(password);

	}

	public void clickSubmit() {
		driver.findElement(log_butt).click();

	}

	public boolean cheeckLogoPresent() {

		boolean displayed = driver.findElement(img_log_image).isDisplayed();

		return displayed;
	}

	public void setLogout() {

		driver.findElement(logout_butt).click();

	}

	public boolean cheeckHomePageLogo() {

		boolean home_logo = driver.findElement(login_logo).isDisplayed();

		return home_logo;
	}
}
