package day9;

import org.testng.annotations.Test;

public class Grouping {
	@Test(priority = 1, groups = { "sanity", "regression" })
	void loginByEmail() {

		System.out.println("this is login by email");
	}

	@Test(priority = 2, groups = { "sanity" })
	void loginByFacebook() {

		System.out.println("this is login by facebook");
	}

	@Test(priority = 3, groups = { "sanity" })
	void loginByTwitter() {

		System.out.println("this is login by twitter");
	}

	@Test(priority = 4, groups = { "sanity", "regression" })
	void signupByEmail() {

		System.out.println("this is signup by email");
	}

	@Test(priority = 5, groups = { "regression" })
	void signupByFacebook() {

		System.out.println("this is signup by Facebook");
	}

	@Test(priority = 6, groups = { "regression" })
	void signupByTwitter() {

		System.out.println("this is signup by Twitter");
	}

	@Test(priority = 7, groups = { "sanity", "regression" })
	void paymentinRupees() {

		System.out.println("Payment in Rupees");
	}

	@Test(priority = 8, groups = { "sanity" })
	void paymentinDollar() {

		System.out.println("Payment in doller");
	}

	@Test(priority = 9, groups = { "regression" })
	void paymentinBank() {
		System.out.println("Payment return by bank");
	}

}
