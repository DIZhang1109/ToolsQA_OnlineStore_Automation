package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.iMacsPageGridView_Action;
import executionAction.iMacsPageListView_Action;

public class TestCase005_BrowseiMacs {
	
	@Test(priority = 1)
	public void testCase005_BrowseiMacsListView() throws Exception {
		iMacsPageListView_Action implva = new iMacsPageListView_Action();
		WebDriver driver = implva.driver;
		implva.get();
		System.out.println("TestCase005_BrowseiMacsListView:" + "\n" + "-----------------------------------------------------");
		
		implva.assertPageText();
		implva.assertProductContentsListView("005_iMacsPage");
		implva.viewProductImage();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
	
	@Test(priority = 2)
	public void testCase005_BrowseiMacsGridView() throws Exception {
		iMacsPageGridView_Action impgva = new iMacsPageGridView_Action();
		WebDriver driver = impgva.driver;
		impgva.get();
		System.out.println("TestCase005_BrowseiMacsGridView:" + "\n" + "-----------------------------------------------------");
		
		impgva.assertPageText();
		impgva.assertProductContentsGridView("005_iMacsPage");
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
