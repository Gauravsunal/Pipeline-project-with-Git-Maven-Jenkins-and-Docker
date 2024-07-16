package com.sdet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
	@Test
	public void testlogin1() {
		App myapp=new App();
		Assert.assertEquals(false, myapp.userLogin("abc", "abc123"));
	}
	
	@Test
	public void testlogin2() {
		App myapp=new App();
		Assert.assertEquals(false, myapp.userLogin("abc", "abc@123"));
	}
}
