package day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	@Test
	public void test() {

		int a = 21;
		int b = 20;
		/*
		 * if (a == b) {
		 * 
		 * System.out.println("Test is pass"); } else {
		 * 
		 * System.out.println("Test is Fail"); }
		 */
		// Assert.assertEquals(a, b);

		// Assert.assertEquals(a > b, true, "Please cheek the data you passed");
		String s1 = "abc";
		String s2 = "abc1";
		// Assert.assertEquals(s1,s2, "both are not equal");
		//Assert.assertNotEquals(s1, s2, "both are equals");
		
		
		if(false) {
			
			Assert.assertTrue(true);
		}else {
			
			//Assert.assertTrue(false);
			Assert.fail();

		}
	}
}
