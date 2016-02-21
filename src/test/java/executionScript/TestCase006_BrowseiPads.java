package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.iPadsPageGridView_Action;
import executionAction.iPadsPageListView_Action;

public class TestCase006_BrowseiPads {
	
	@Test(priority = 1)
	public void testCase006_BrowseiPadsListView() throws Exception {
		iPadsPageListView_Action ipdplva = new iPadsPageListView_Action();
		WebDriver driver = ipdplva.driver;
		ipdplva.get();
		System.out.println("TestCase006_BrowseiPadsListView:" + "\n" + "-----------------------------------------------------");
		
		ipdplva.assertPageText();
		ipdplva.assertProductContentsListView("006_iPadsPage");
		ipdplva.viewProductImage();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
	
	@Test(priority = 2)
	public void testCase006_BrowseiPadsGridView() throws Exception {
		iPadsPageGridView_Action ipdpgva = new iPadsPageGridView_Action();
		WebDriver driver = ipdpgva.driver;
		ipdpgva.get();
		System.out.println("TestCase006_BrowseiPadsGridView:" + "\n" + "-----------------------------------------------------");
		
		ipdpgva.assertPageText();
		ipdpgva.assertProductContentsGridView("006_iPadsPage");
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
