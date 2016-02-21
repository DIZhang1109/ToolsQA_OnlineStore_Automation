package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.AddToCart_Action;

public class TestCase012_BuyAllProducts {

	@Test
	public void testCase012_BuyAllProducts() throws Exception {
		AddToCart_Action atca = new AddToCart_Action();
		WebDriver driver = atca.driver;
		atca.get();
		System.out.println("TestCase012_BuyAllProducts:" + "\n" + "-----------------------------------------------------");
		
		atca.addtoCartAll();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
