package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.iPodsPageGridView_Action;
import executionAction.iPodsPageListView_Action;

public class TestCase008_BrowseiPods {
	
	@Test(priority = 1)
	public void testCase008_BrowseiPodsListView() throws Exception {
		iPodsPageListView_Action ipoplva = new iPodsPageListView_Action();
		WebDriver driver = ipoplva.driver;
		ipoplva.get();
		System.out.println("TestCase008_BrowseiPodsListView:" + "\n" + "-----------------------------------------------------");
		
		ipoplva.assertPageText();
		ipoplva.assertProductContentsListView("008_iPodsPage");
		ipoplva.viewProductImage();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
	
	@Test(priority = 2)
	public void testCase008_BrowseiPodsGridView() throws Exception {
		iPodsPageGridView_Action ipopgva = new iPodsPageGridView_Action();
		WebDriver driver = ipopgva.driver;
		ipopgva.get();
		System.out.println("TestCase008_BrowseiPodsGridView:" + "\n" + "-----------------------------------------------------");
		
		ipopgva.assertPageText();
		ipopgva.assertProductContentsGridView("008_iPodsPage");
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
