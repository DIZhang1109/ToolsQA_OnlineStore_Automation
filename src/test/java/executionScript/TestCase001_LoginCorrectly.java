package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.Login_Action;

public class TestCase001_LoginCorrectly {

	@Test
	public void testCase001_LoginCorrectly() throws Exception {
		Login_Action la = new Login_Action();
		WebDriver driver = la.driver;
		la.get();
		System.out.println("TestCase001_LoginCorrectly:" + "\n" + "-----------------------------------------------------");
		
		la.assertMainPageURL();
		la.testLogin("001_LoginCorrectly");

		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
