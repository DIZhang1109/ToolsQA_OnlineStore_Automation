package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.AccessoriesPageGridView_Action;
import executionAction.AccessoriesPageListView_Action;

public class TestCase004_BrowseAccessories {
	
	@Test(priority = 1)
	public void testCase004_BrowseAccessoriesListView() throws Exception {
		AccessoriesPageListView_Action aplva = new AccessoriesPageListView_Action();
		WebDriver driver = aplva.driver;
		aplva.get();
		System.out.println("TestCase004_BrowseAccessoriesListView:" + "\n" + "-----------------------------------------------------");
		
		aplva.assertPageText();
		aplva.assertProductContentsListView("004_AccessoriesPage");
		aplva.viewProductImage();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
	
	@Test(priority = 2)
	public void testCase004_BrowseAccessoriesGridView() throws Exception {
		AccessoriesPageGridView_Action apgva = new AccessoriesPageGridView_Action();
		WebDriver driver = apgva.driver;
		apgva.get();
		System.out.println("TestCase004_BrowseAccessoriesGridView:" + "\n" + "-----------------------------------------------------");
		
		apgva.assertPageText();
		apgva.assertProductContentsGridView("004_AccessoriesPage");
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
