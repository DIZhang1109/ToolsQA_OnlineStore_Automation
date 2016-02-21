package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.MacBooksPageGridView_Action;
import executionAction.MacBooksPageListView_Action;

public class TestCase009_BrowseMacBooks {
	
	@Test(priority = 1)
	public void testCase009_BrowseMacBooksListView() throws Exception {
		MacBooksPageListView_Action mbplva = new MacBooksPageListView_Action();
		WebDriver driver = mbplva.driver;
		mbplva.get();
		System.out.println("TestCase009_BrowseMacBooksListView:" + "\n" + "-----------------------------------------------------");
		
		mbplva.assertPageText();
		mbplva.assertProductContentsListView("009_MacBooksPage");
		mbplva.viewProductImage();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
	
	@Test(priority = 2)
	public void testCase009_BrowseMacBooksGridView() throws Exception {
		MacBooksPageGridView_Action mbpgva = new MacBooksPageGridView_Action();
		WebDriver driver = mbpgva.driver;
		mbpgva.get();
		System.out.println("TestCase009_BrowseMacBooksGridView:" + "\n" + "-----------------------------------------------------");
		
		mbpgva.assertPageText();
		mbpgva.assertProductContentsGridView("009_MacBooksPage");
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
