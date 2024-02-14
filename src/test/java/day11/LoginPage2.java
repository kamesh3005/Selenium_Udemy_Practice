package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	WebDriver driver;

	// constructor
	LoginPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement locator + Identification
	@FindBy(how=How.XPATH,using= "//div[@class='page-title']/child::h1")
	WebElement img_log_image;
	@FindBy(id = "Email")
	WebElement txt_username_loc;
	@FindBy(id = "Password")
	WebElement txt_pass_loc;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement log_butt;
	@FindBy(xpath = "//img[@class='brand-image-xl logo-xl']")
	WebElement login_logo;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout_butt;

	// Action Method

	public void setUserName(String username) {

		txt_username_loc.clear();
		txt_username_loc.sendKeys(username);

	}

	public void setPassword(String password) {
		txt_pass_loc.clear();
		txt_pass_loc.sendKeys(password);

	}

	public void clickSubmit() {
		log_butt.click();

	}

	public boolean cheeckLogoPresent() {

		boolean displayed = img_log_image.isDisplayed();

		return displayed;
	}

	public void setLogout() {

		logout_butt.click();

	}

	public boolean cheeckHomePageLogo() {

		boolean home_logo = login_logo.isDisplayed();

		return home_logo;
	}

}
