package day8;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertVsSoftAssert {
	// @Test
	public void hardAssert() {

		System.out.println("test1..........");
		System.out.println("test2..........");
		System.out.println("test3..........");
		System.out.println("test4..........");
		System.out.println("test5..........");
		System.out.println("test6..........");

		Assert.assertEquals(1, 2);
		System.out.println("Hard Assert completed............");

	}

	@Test

	public void softAssert() {
		System.out.println("test1..........");
		System.out.println("test2..........");
		System.out.println("test3..........");
		System.out.println("test4..........");
		System.out.println("test5..........");
		System.out.println("test6..........");

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);

		System.out.println("Soft Assert completed");
		sa.assertEquals(1, 1);
		System.out.println("Soft Assert completed2");

		sa.assertAll();
	}
}
