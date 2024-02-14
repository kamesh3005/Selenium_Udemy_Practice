package day8;

import org.testng.annotations.Test;

public class NewTest {

	@Test(priority = 1)
	public void b() {
		System.out.println("test1");
	}

	@Test(priority = 1)
	public void a() {

		System.out.println("test2");
	}
}
