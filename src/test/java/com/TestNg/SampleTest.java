package com.TestNg;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(groups="smokesuite")
	public void TestScript_1()
	{
		System.out.println("TestScript_1");
	}
	@Test(groups="regressionsuite")
	public void TestScript_2()
	{
		System.out.println("TestScript_2");
	}


}
