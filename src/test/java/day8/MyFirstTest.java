package day8;

import org.testng.annotations.Test;

public class MyFirstTest {
	@Test(priority = -50)
	public void openApp() {

		System.out.println("openApp");

	}

	@Test(priority = -20)
	public void login() {
		System.out.println("login");

	}

	@Test(priority = 0)
	public void closeDriver() {
		System.out.println("Close Driver");

	}
	@Test()
	public void testDriver() {
		System.out.println("Close Driver");

	}
}
