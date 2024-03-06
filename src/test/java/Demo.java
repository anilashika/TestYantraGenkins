import org.testng.annotations.Test;

public class Demo {
		@Test(groups="regression")
		public void TestScript_1()
		{
			System.out.println("TestScript_1");
		}
		@Test(groups="smoke")
		public void TestScript_2()
		{
			System.out.println("TestScript_2");
		}

	}


