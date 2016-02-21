package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.Login_Action;

public class TestCase002_LoginIncorrectly {
	
	@Test
	public void testCase002_LoginIncorrectly() throws Exception {
		Login_Action la = new Login_Action();
		WebDriver driver = la.driver;
		la.get();
		System.out.println("TestCase002_LoginIncorrectly:" + "\n" + "-----------------------------------------------------");
		
		la.assertMainPageURL();
		la.testLogin("002_LoginIncorrectly");

		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
