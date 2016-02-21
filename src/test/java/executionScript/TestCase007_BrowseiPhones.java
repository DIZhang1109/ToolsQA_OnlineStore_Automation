package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.iPhonesPageGridView_Action;
import executionAction.iPhonesPageListView_Action;

public class TestCase007_BrowseiPhones {
	
	@Test(priority = 1)
	public void testCase007_BrowseiPhonesListView() throws Exception {
		iPhonesPageListView_Action iphplva = new iPhonesPageListView_Action();
		WebDriver driver = iphplva.driver;
		iphplva.get();
		System.out.println("TestCase007_BrowseiPhonesListView:" + "\n" + "-----------------------------------------------------");
		
		iphplva.assertPageText();
		iphplva.assertProductContentsListView("007_iPhonesPage");
		iphplva.viewProductImage();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
	
	@Test(priority = 2)
	public void testCase007_BrowseiPhonesGridView() throws Exception {
		iPhonesPageGridView_Action iphpgva = new iPhonesPageGridView_Action();
		WebDriver driver = iphpgva.driver;
		iphpgva.get();
		System.out.println("TestCase006_BrowseiPhonesGridView:" + "\n" + "-----------------------------------------------------");
		
		iphpgva.assertPageText();
		
		iphpgva.assertProductContentsGridView("007_iPhonesPage");
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
