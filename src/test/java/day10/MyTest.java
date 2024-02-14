package day10;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {

	@Test(priority = 1)

	void test1() {

		AssertJUnit.assertEquals(1, 1);

	}

	@Test(priority = 2)
	void test2() {

		AssertJUnit.assertEquals("A", "B");

	}

	@Test(priority = 3, dependsOnMethods = { "test2" })
	void test3() {
		AssertJUnit.assertEquals("A", "A");

	}

}
