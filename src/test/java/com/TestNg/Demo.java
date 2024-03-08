package com.TestNg;

import org.testng.annotations.Test;

public class Demo {
	
	@Test(groups="regressionsuite")
	public void TestScript_5()
	{
		System.out.println("TestScript_1");
	}
	@Test(groups="smokesuite")
	public void TestScript_6()
	{
		System.out.println("TestScript_2");
	}
	@Test(groups="integrationsuite")
	public void TestScript_7()
	{
		System.out.println("TestScript_7");
		
	}


}
