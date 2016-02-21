package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.AddToCart_Action;

public class TestCase011_BuySeveralProducts {
	
	@Test
	public void testCase011_BuySeveralProducts() throws Exception {
		AddToCart_Action atca = new AddToCart_Action();
		WebDriver driver = atca.driver;
		atca.get();
		System.out.println("TestCase011_BuySeveralProducts" + "\n" + "-----------------------------------------------------");
		
		atca.addtoCartSeveralTime(3);
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
