package day8;

import org.testng.annotations.*;

public class AnnotationDemo {

	@BeforeSuite

	void setSystemProperty() {

		System.out.println("System Property");
	}

	@BeforeTest

	void launchBrowser() {

		System.out.println("Browser Launch");
	}

	@BeforeClass

	void login() {

		System.out.println("Login to app");
	}

	@BeforeMethod

	void enterUrl() {

		System.out.println("Url");
	}

	@Test
	void searchMenu() {

		System.out.println("Search Test");
	}

	@Test
	void homeSearch() {

		System.out.println("Home Search");
	}

	@Test
	void addTocartTest() {

		System.out.println("Add to cart");
	}

	@AfterMethod
	void logOut() {

		System.out.println("logout from app");
	}

	@AfterClass
	void closeBrowser() {

		System.out.println("Close Browser");
	}

	@AfterTest
	void deletCookies() {

		System.out.println("Delet cookies");
	}

}
