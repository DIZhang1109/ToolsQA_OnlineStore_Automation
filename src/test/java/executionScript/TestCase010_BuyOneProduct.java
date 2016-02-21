package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.AddToCart_Action;

public class TestCase010_BuyOneProduct {
	
	@Test
	public void testCase010_BuyOneProduct() throws Exception {
		AddToCart_Action atca = new AddToCart_Action();
		WebDriver driver = atca.driver;
		atca.get();
		System.out.println("TestCase010_BuyOneProduct:" + "\n" + "-----------------------------------------------------");
		
		atca.addtoCartOnce();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
