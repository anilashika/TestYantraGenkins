import org.testng.annotations.Test;

public class Sample {
	@Test(groups="smoke")
	public void TestScript_1()
	{
		System.out.println("TestScript_5");
	}
	@Test(groups="regression")
	public void TestScript_2()
	{
		System.out.println("TestScript_6");
	}

}
